package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.EventData;
import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {



    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Browns v. Chiefs");
//        events.add("Lakers v. Warriors");
//        events.add("Cubs v. Cardinals");
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Sporting Event");
        model.addAttribute(new Event());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            model.addAttribute("dateErrorMsg", "Invalid date format MM/DD/YY");
            return "events/create";
        }
        EventData.addEvents(newEvent);
        return "redirect:";
    }




}
