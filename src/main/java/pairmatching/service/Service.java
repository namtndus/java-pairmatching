package pairmatching.service;

import pairmatching.domain.*;
import pairmatching.model.InputFile;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.view.InputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Service {
    InputView inputView = new InputView();
    InputFile inputFile = new InputFile();
    List<String> backendCrew = inputFile.inputBackendCrews();
    List<String> frontendCrew = inputFile.inputFrontendCrews();
    PairMatchingRepository pairMatchingRepository = new PairMatchingRepository();

    public void saveLogic(){
        String[] programeInfo = vaildAnswer();
        PairMatching pairMatching = new PairMatching(programeInfo);
        if(pairMatchingRepository.containPairMatching(pairMatching)){
            String restartReq= inputView.restartMatchedInfo();
            if(restartReq.equals("아니요")){
                saveLogic();
            }
        }
    }

    public LinkedHashMap<Crew,Crew> printCrewList(){
        String[] programeInfo = vaildAnswer();
        PairMatching pairMatching = new PairMatching(programeInfo);
        return pairMatchingRepository.getPairMatchings(pairMatching);

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

    // 객체를 저장하기 전에 중복된 수가 있는지 확인하는 함수
    public void save(String[] userAnswer){
        List<Crew> changeCrew = changeStringToCrew(backendCrew);
        List<Mission> getMissions = Level.findMissions(userAnswer[1]);

        for(Mission mis : getMissions){
            PairMatching pairMatching = new PairMatching(userAnswer);
            // true 이면 중복된 숫자가 있다는 표시이다.
            if(pairMatchingRepository.equalsCrews(pairMatching,changeCrew)){
                System.out.println("바꾸기");
                break;
            }

        }
    }
}
