package pairmatching.domain;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차게임"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_CAR("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE("지하철노선도");

    private String missionName;

    Mission(String missionName){
        this.missionName = missionName;
    }

    public static Mission findMission(String missionName){
        return Arrays.stream(values())
                .filter(mission -> mission.missionName.equals(missionName))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException("[ERROR] 해당 미션은 없습니다"));
    }

}
