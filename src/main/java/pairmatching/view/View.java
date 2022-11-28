package pairmatching.view;


import camp.nextstep.edu.missionutils.Console;

public class View {

    public String printMenu(){
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        String userAnswer = Console.readLine();
        System.out.println();
        return userAnswer;
    }

    public String printCourseInfo(){
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("\t- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("\t- 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("\t- 레벨3: ");
        System.out.println("\t- 레벨4: 성능개선 | 배포");
        System.out.println("\t- 레벨5: ");
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String userAnswer = Console.readLine();
        System.out.println();
        return userAnswer;
    }
}
