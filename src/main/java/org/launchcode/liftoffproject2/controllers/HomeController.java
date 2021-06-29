package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.EventData;
import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.data.TypeOfEventRepository;
import org.launchcode.liftoffproject2.data.UserRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.launchcode.liftoffproject2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TypeOfEventRepository typeOfEventRepository;

    @Autowired
    private UserRepository userRepository;

//    @GetMapping
//    public String index(Model model){
//
//        model.addAttribute("events",eventRepository.findAll());
//
//        return "index";
//    }

    @GetMapping
    public String displayAllEvents(Model model) {
//        User user= userRepository.findByUsername(userName);
//        userRepository.save(user);
        model.addAttribute("title", "Welcome User");
        model.addAttribute("events", eventRepository.findAll());
        return "index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Sporting Event");
        model.addAttribute(new Event());
        model.addAttribute("types", typeOfEventRepository.findAll());
        return "events/create";
    }

    @PostMapping
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            model.addAttribute("types", typeOfEventRepository.findAll());
            model.addAttribute("dateErrorMsg", "Invalid date format MM/DD/YY");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }


}
