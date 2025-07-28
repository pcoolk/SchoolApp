package com.prashant.school.schoolapp.model;

import lombok.Data;

//@Data is the annotation provided by lombok.
@Data
public class Contact {

    //variable names from contact.html
    private String name;
    private String mobileNum;
    private String email;
    private String subject;
    private String message;

    /*all the getter setter and toString methods deleted to use Lombok, which automatically initializes
    them automatically
    */
}
