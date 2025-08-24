package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Holiday;
import com.prashant.school.schoolapp.repository.HolidaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class holidayController {

    @Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model){
        if(null!=display && display.equals("all")){
            model.addAttribute("festival", true);
            model.addAttribute("national", true);
        } else if (null!=display && display.equals("national")) {
            model.addAttribute("national",true);
        } else if (null!=display && display.equals("festival")) {
            model.addAttribute("festival",true);
        }
        List<Holiday> holidays = holidaysRepository.findAllHolidays();
        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type:types){
            model.addAttribute(type.toString(),(holidays.stream().filter(holiday -> holiday
                    .getType().equals(type)).collect(Collectors.toList())));
        }
        return "holiday.html";
    }
}
