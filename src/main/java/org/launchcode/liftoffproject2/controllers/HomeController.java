package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private static List<Event> events=new ArrayList<>();

    @GetMapping("create")
    public String index(Model model){

        model.addAttribute("events",events);

        return "index";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam Date eventDate){
        events.add(new Event(eventName, eventDescription, eventDate));
        return "redirect:";
    }


}
