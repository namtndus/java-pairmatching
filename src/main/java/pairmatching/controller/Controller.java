package pairmatching.controller;

import pairmatching.service.Service;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Service service = new Service();

    public void menuInfo(){
        String input = "";
        while (!input.equals("Q")){
            input = inputView.menuMessage();
            if(input.equals("1")){
                outputView.programInfo();
                outputView.printCrews(service.saveLogic());
            }
            if(input.equals("2")){
                outputView.programInfo();
                service.printCrewList();
            }
            if(input.equals("3")){
                service.clear();
                outputView.clearMessage();
            }
        }
    }
}
