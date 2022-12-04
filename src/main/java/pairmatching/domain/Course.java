package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Course findCourse(String courseName){
        return Arrays.stream(values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() ->new IllegalArgumentException("[ERROR] 없는 코스입니다"));
    }
}
