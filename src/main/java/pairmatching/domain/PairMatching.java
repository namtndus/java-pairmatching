package pairmatching.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class PairMatching {
    private final Course course;
    private final Level level;
    private final Mission mission;
    private LinkedHashMap<Crew,Crew> pairMatching = new LinkedHashMap<>();

    // 생성자
    public PairMatching(String[] userAnswrs){
        this.course = Course.findCourse(userAnswrs[0]);
        this.level = Level.findLevel(userAnswrs[1]);
        this.mission = Mission.findMission(userAnswrs[2]);
        pairMatching.clear();
    }


    //
    public void save(List<Crew> suffleCrews){
        for(int suffleCrewsIndex = 0; suffleCrewsIndex < suffleCrews.size()/2; suffleCrewsIndex++){
            pairMatching.put(suffleCrews.get(suffleCrewsIndex*2),suffleCrews.get(suffleCrewsIndex*2+1));
        }
        if(suffleCrews.size() %2 ==1){
            pairMatching.put(suffleCrews.get(suffleCrews.size()-3),suffleCrews.get(suffleCrews.size()-2));
            pairMatching.put(suffleCrews.get(suffleCrews.size()-2),suffleCrews.get(suffleCrews.size()-1));
        }
    }

    public boolean containCrews(Crew crew, Crew otherCrew){
        if(pairMatching.containsKey(crew)){
            pairMatching.get(crew).equals(otherCrew);
            return true;
        }
        if (pairMatching.containsKey(otherCrew)){
            pairMatching.get(otherCrew).equals(crew);
            return true;
        }
        return false;
    }

    public LinkedHashMap<Crew,Crew> getPairMatching(){
        return pairMatching;
    }
    public void clear(){
        pairMatching.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        PairMatching crews = (PairMatching) obj;
        return this.course == crews.course && this.level == crews.level && this.mission == crews.mission;
    }
}
