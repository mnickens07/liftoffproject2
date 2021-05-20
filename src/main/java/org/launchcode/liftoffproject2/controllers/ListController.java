package org.launchcode.liftoffproject2.controllers;


import org.launchcode.liftoffproject2.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping(value="list")
public class ListController {

    @Autowired
    private EventRepository evenRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController() {
        columnChoices.put("all", "All");
        columnChoices.put("events", "Events");
    }

    @RequestMapping
    public String list(Model model) {
        model.addAttribute("events", evenRepository.findAll());
        return "list";
    }

}
