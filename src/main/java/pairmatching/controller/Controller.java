package pairmatching.controller;

import pairmatching.service.Service;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Service service = new Service();

    public void menuInfo(){
        String input = inputView.menuMessage();
        if(input.equals("1")){
            outputView.programInfo();
            inputView.inputUserAnswer();
        }
        if(input.equals("2")){
            outputView.programInfo();
            outputView.printCrews(service.printCrewList());
        }
        if(input.equals("3")){
            service.clear();
            outputView.clearMessage();
        }
    }
}
