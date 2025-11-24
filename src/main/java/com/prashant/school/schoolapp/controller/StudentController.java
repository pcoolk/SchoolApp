package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Person;
import com.prashant.school.schoolapp.repository.EazyClassRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("student")
public class StudentController {

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession httpSession){
        Person person = (Person) httpSession.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("courses_enrolled");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
