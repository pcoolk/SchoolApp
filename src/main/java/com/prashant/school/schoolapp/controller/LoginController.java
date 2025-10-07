package com.prashant.school.schoolapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    @GetMapping("/login")
    public String displayLogin(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               @RequestParam(value = "register", required = false) String register,
                               Model model){

        String errorMessage =  null;
        if(error!=null){
            errorMessage = "Invalid credentials!";
        }
        else if(logout!=null){
            errorMessage = "You have been logged out!";
        } else if (register!=null) {
            errorMessage = "You are registered. Login with registered credentials.";
            
        }
        model.addAttribute("errorMessage", errorMessage);

        return "/login";
    }
//    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth!=null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login?logout=true";
//    }


}
