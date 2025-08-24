package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Contact;
import com.prashant.school.schoolapp.service.contactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Slf4j
@Controller
public class contactController {

    private final contactService contactService;

    @Autowired
    public contactController(contactService contactService){
        this.contactService = contactService;
    }
    @RequestMapping("/contact")
    public String displayContact(Model model){
        model.addAttribute("contact", new Contact());
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
    @RequestMapping(value = "/saveMsg", method = POST)
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("contact form validation failed due to: "+errors.toString());
            return "contact";
        }
        contactService.saveMessage(contact);
        return "redirect:/contact";
    }
    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model){
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView  = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs", contactMsgs);
        return modelAndView;
    }
}
