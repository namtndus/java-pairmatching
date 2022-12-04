package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR,Mission.LOTTO,Mission.BASEBALL_GAME)),
    LEVEL2("레벨2",Arrays.asList(Mission.SHOPPING_CAR,Mission.PAYMENT,Mission.SUBWAY_LINE)),
    LEVEL3("레벨3",Arrays.asList()),
    LEVEL4("레벨4",Arrays.asList()),
    LEVEL5("레벨5",Arrays.asList());

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level findLevel(String levelName){
        return Arrays.stream(values())
                .filter(level -> level.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당하는 레벨이 없습니다"));
    }

    public Mission containMission(String missionName){
        Mission mission = Mission.findMission(missionName);
        if(!missions.contains(mission)){
            throw new IllegalArgumentException("[ERROR] 해당 레벨에 없는 미션입니다");
        }
        return mission;
    }

    public static List<Mission> findMissions(String levelName){
        return Arrays.stream(values())
                .filter(level -> level.name.equals(levelName))
                .findAny()
                .get().missions;
    }
}
