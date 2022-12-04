package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.domain.PairMatching;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PairMatchingRepository {
    List<PairMatching> pairMatchings = new ArrayList<>();

    public void save(PairMatching pairMatching){
        if(containPairMatching(pairMatching)){
            getPairMatchings(pairMatching).clear();
        }
        pairMatchings.add(pairMatching);
    }

    public boolean equalsCrews(PairMatching pairMatching,List<Crew> suffledCrews){
        for(PairMatching pair : pairMatchings){
            // 있으면 출력
            if(pair.equals(pairMatching)){
                for(int suffledCrewsIndex = 0; suffledCrewsIndex <suffledCrews.size()/2; suffledCrewsIndex+=2){
                    boolean result = pair.containCrews(suffledCrews.get(suffledCrewsIndex*2),suffledCrews.get(suffledCrewsIndex*2+1));
                    if(result){
                        return true;
                    }
                }
                if(suffledCrews.size() % 2 == 1){
                    if(!(pair.containCrews(suffledCrews.get(suffledCrews.size()-3),suffledCrews.get(suffledCrews.size()-2)) ||
                            pair.containCrews(suffledCrews.get(suffledCrews.size()-2),suffledCrews.get(suffledCrews.size()-1))))
                        return true;

                }
            }
        }
        return false;
    }

    public LinkedHashMap<Crew,Crew> getPairMatchings(PairMatching pairMatching) {
        return pairMatchings.stream().filter(pair -> pair.equals(pairMatching))
                .findAny().get().getPairMatching();
    }

    // 객체가 포함이 되어있는지 확인함
    public boolean containPairMatching(PairMatching pairMatching){
        for(PairMatching pair : pairMatchings){
            if(pair.equals(pairMatching)){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        pairMatchings.stream().forEach(i -> i.clear());
        pairMatchings.clear();
    }
}
