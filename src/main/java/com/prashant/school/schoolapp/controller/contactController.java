package com.prashant.school.schoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contactController {

    @RequestMapping("/contact")
    public String displayContact(){
        return "contact.html";
    }
}
