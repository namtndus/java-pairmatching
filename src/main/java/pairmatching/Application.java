package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.View;

public class Application {

    private static View view = new View();
    public static void main(String[] args) {
        // TODO 구현 진행
        String userAnswer;
        do {
            userAnswer = view.printMenu();
        }while (userAnswer.equals("Q"));
    }
}
