package pairmatching.domain;

import java.util.Objects;

public class Crew {
    private String name;

    public Crew(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        Crew crew = (Crew) obj;
        return Objects.equals(this,obj);
    }

    @Override
    public String toString() {
        return name;
    }
}
