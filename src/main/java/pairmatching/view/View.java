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
}
