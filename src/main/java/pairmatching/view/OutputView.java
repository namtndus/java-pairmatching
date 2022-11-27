package pairmatching.view;

import static pairmatching.model.PairMatchingMessageConst.*;
import static pairmatching.model.StartMessageConst.*;

public class OutputView {

    public void startMessage(){
        System.out.println(START_MESSAGE);
        System.out.println(FIRST_LOGIC);
        System.out.println(SECOND_LOGIC);
        System.out.println(THIRD_LOGIC);
        System.out.println(EXIT_LOGIC);
    }

    public void printPairMatcingMessage(){
        System.out.println(VERTICAL_BAR);
        System.out.println(TYPE_OF_COURSE);
        System.out.println(TYPE_OF_LEVELS);
        System.out.println(VERTICAL_BAR);
        System.out.println(QUESTION);
        System.out.println(EXAMPLE_MESSAGE);
    }
}
