package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.launchcode.liftoffproject2.controllers.ListController.columnChoices;

public class SearchController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping
    public String search(Model model){
        model.addAttribute("columns", columnChoices);
        return "search";
    }

   /* @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Event> events;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            events = eventRepository.findAll();
        } else {
            events = EventData.findByColumnAndValue(searchType, searchTerm, eventRepository.findAll());
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("title", "Events with " + columnChoices.get(searchType) + ": " + searchTerm);
        model.addAttribute("events", events);

        return "search";
    }*/

}
