package com.prashant.school.schoolapp.model;

import jakarta.persistence.*;
import lombok.Data;

//@Data is the annotation provided by lombok.
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity{
    @Id
    private  String day;
    private  String reason;

    @Enumerated(EnumType.STRING)
    private  Type type;

    public enum Type{
        FESTIVAL, NATIONAL
    }

    /*
    Removed all the getters and Holiday constructor because lombok  initializes them automatically
    * */
}
