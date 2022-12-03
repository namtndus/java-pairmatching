package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String menuMessage(){
        System.out.println("기능을 선택하세요");
        System.out.printf("1. 페어 매칭");
        System.out.printf("2. 페어 조회");
        System.out.printf("3. 페어 초기화");
        System.out.printf("Q. 페어 초기화");
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String inputUserAnswer(){
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public String restartMatchedInfo(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
