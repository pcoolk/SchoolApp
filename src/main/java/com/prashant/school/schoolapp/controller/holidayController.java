package com.prashant.school.schoolapp.controller;

import com.prashant.school.schoolapp.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class holidayController {

    @GetMapping("/holidays") // Changed to a simpler, conventional URL
    public String displayHolidays(@RequestParam(required = false) Boolean festival,
                                  @RequestParam(required = false) Boolean national,
                                  Model model) {

        // If 'display' parameter is not present, default to showing all holidays.
        if(festival == null && national == null){
            model.addAttribute("festival", true);
            model.addAttribute("national", true);
        }
        else{
            model.addAttribute("festival", festival!=null && festival);
            model.addAttribute("national", national!=null && national);
        }


        List<Holiday> holidays = Arrays.asList(
                new Holiday(" Jan 26 ","Republic Day", Holiday.Type.NATIONAL),
                new Holiday(" Mar 29 ","Holi", Holiday.Type.FESTIVAL),
                new Holiday(" Apr 18 ","Good Friday", Holiday.Type.FESTIVAL),
                new Holiday(" May 1 ","Labour Day", Holiday.Type.NATIONAL),
                new Holiday(" Aug 15 ","Independence Day", Holiday.Type.NATIONAL),
                new Holiday(" Oct 2 ","Gandhi Jayanti", Holiday.Type.NATIONAL),
                new Holiday(" Oct 21 ","Dussehra", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 10 ","Diwali", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ","Christmas", Holiday.Type.FESTIVAL)
        );

        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidays.stream().filter(holiday -> holiday.getType().equals(type)).collect(Collectors.toList())));
        }

        return "holiday.html";
    }
}
