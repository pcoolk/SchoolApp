package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping(value = {"","/","home"})
public String display(Model model){

    model.addAttribute("username", "Prashant");
    model.addAttribute("contact", new Contact());
    return("home");
}
}
