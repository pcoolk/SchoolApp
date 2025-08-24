package com.prashant.school.schoolapp.model;

import lombok.Data;

//@Data is the annotation provided by lombok.
@Data
public class Holiday extends BaseEntity{
    private  String day;
    private  String reason;
    private  Type type;

    public enum Type{
        FESTIVAL, NATIONAL
    }

    /*
    Removed all the getters and Holiday constructor because lombok  initializes them automatically
    * */
}
