package com.prashant.school.schoolapp.model;

import lombok.Data;

//@Data is the annotation provided by lombok.
@Data
public class Holiday {
    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }

    /*
    Removed all the getters and Holiday constructor because lombok  initializes them automatically
    * */
}
