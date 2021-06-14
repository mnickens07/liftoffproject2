package org.launchcode.liftoffproject2.controllers;


import org.launchcode.liftoffproject2.data.EventData;
import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.data.TagRepository;
import org.launchcode.liftoffproject2.data.TypeOfEventRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value="list")
public class ListController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TypeOfEventRepository typeOfEventRepository;

    @Autowired
    private TagRepository tagRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("tags", "Tags");
        columnChoices.put("type", "Type");
    }

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("columns", columnChoices);
        model.addAttribute("type", typeOfEventRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "list";
    }

    @RequestMapping(value="events")
    public String listEventsByColumnAndValue(Model model, @RequestParam String value, @RequestParam String column) {
        Iterable<Event> events;
        if (column.toLowerCase().equals("all")){
            events = eventRepository.findAll();
            model.addAttribute("title", "All Events");
            model.addAttribute("events", events);
        } else {
            events = EventData.findByColumnAndValue(column, value, eventRepository.findAll());
            model.addAttribute("title", "Events with " + columnChoices.get(column)+": "+ value);
        }
        model.addAttribute("events", events);
        return "list-types";
    }

}
