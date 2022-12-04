package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.*;
import pairmatching.model.InputFile;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Service {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputFile inputFile = new InputFile();
    List<String> backendCrew = inputFile.inputBackendCrews();
    List<String> frontendCrew = inputFile.inputFrontendCrews();
    PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();

    public LinkedHashMap<Crew,Crew> saveLogic(){
        List<String> crew;
        String[] programeInfo = vaildAnswer();
        PairMatching pairMatching = new PairMatching(programeInfo);
        if(pairMatchingRepository.containPairMatching(pairMatching)){
            String restartReq= inputView.restartMatchedInfo();
            if(restartReq.equals("아니요")){
                saveLogic();
            }
        }
        if(programeInfo[0].equals("백엔드")){
            crew = Randoms.shuffle(backendCrew);
        }else {
            crew = Randoms.shuffle(frontendCrew);
        }

        pairMatching.save(changeStringToCrew(crew));
        pairMatchingRepository.save(pairMatching);
        return pairMatchingRepository.getPairMatchings(pairMatching);
    }

    public void printCrewList(){
        String[] programeInfo = vaildAnswer();
        PairMatching pairMatching = new PairMatching(programeInfo);
        if(pairMatchingRepository.containPairMatching(pairMatching)){
            outputView.printCrews(pairMatchingRepository.getPairMatchings(pairMatching));
        }else {
            System.out.println("[ERROR] 해당 정보는 없습니다");
        }

    }


    public void clear(){
        pairMatchingRepository.clear();
    }

    //유효한 값을 받아왔는지 확인하는 함수
    public String[] vaildAnswer(){
        String userAnswer = inputView.inputUserAnswer();
        String[] answers = userAnswer.split(",\\s");
        try{
            Course course = Course.findCourse(answers[0]);
            Level level = Level.findLevel(answers[1]);
            Mission mission = level.containMission(answers[2]);
        }catch (Exception e){
            System.out.println(e.getMessage());
            vaildAnswer();
        }
        return answers;
    }

    // List<String> -> List<Crew> 으로 바꾸는 함수
    public List<Crew> changeStringToCrew(List<String> shuffledCrew){
        List<Crew> inputCrews = new ArrayList<>();

        for(String crew: shuffledCrew){
            inputCrews.add(new Crew(crew));
        }
        return inputCrews;
    }
}
