package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Contact;
import com.prashant.school.schoolapp.service.contactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class contactController {

    private static final Logger log = LoggerFactory.getLogger(contactController.class);
    private final contactService contactService;

    @Autowired
    public contactController(contactService contactService){
        this.contactService = contactService;
    }
    @RequestMapping("/contact")
    public String displayContact(){
        return "contact.html";
    }
//    @RequestMapping(value = "/saveMsg", method = POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                        @RequestParam String email,@RequestParam String subject,
//                        @RequestParam String message){
//        log.info("Name: " + name);
//        log.info("Mobile: " + mobileNum);
//        log.info("E-mail: " + email);
//        log.info("Subject: " + subject);
//        log.info("Message: " + message);
//        return new ModelAndView("redirect:/contact");
//    }
    @PostMapping("/saveMsg")
    public ModelAndView saveMessage(Contact contact){
        contactService.saveMessage(contact);
        return new ModelAndView("redirect:/contact");
    }
}
