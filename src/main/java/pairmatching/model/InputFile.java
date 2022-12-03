package pairmatching.model;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputFile {

    private final String fileLocation = "/home/namtndus/woowacourse/java-pairmatching/src/main/java/resources/";

    public List<String> inputBackendCrews(){
        List<String> backendCrews = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileLocation+"backend-crew.md"));
            while (true){
                String backendCrew = br.readLine();
                if (backendCrew == null) break;
                backendCrews.add(backendCrew);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return backendCrews;
    }

    public List<String> inputFrontendCrews(){
        List<String> frontendCrews = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileLocation+"frontend-crew.md"));
            while (true){
                String frontendCrew = br.readLine();
                if(frontendCrew == null) break;
                frontendCrews.add(frontendCrew);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return frontendCrews;
    }
}
