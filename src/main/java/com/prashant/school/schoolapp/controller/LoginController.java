package com.prashant.school.schoolapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String displayLogin(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout, Model model){

        String errorMessage =  null;
        if(error!=null){
            errorMessage = "Invalid credentials!";
        }
        if(logout!=null){
            errorMessage = "You have been logged out!";
        }
        model.addAttribute("errorMessage", errorMessage);

        return "/login";
    }


}
