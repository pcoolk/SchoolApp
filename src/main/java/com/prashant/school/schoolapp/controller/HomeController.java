package com.prashant.school.schoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping(value = {"","/","home"})
public String display(Model model){

    model.addAttribute("username", "Prashant");
    return("home");
}
}
