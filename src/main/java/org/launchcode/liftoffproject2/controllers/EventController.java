package org.launchcode.liftoffproject2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String eventHomePage(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Browns v. Chiefs");
        names.add("Lakers v. Warriors");
        names.add("Cubs v. Cardinals");
        model.addAttribute("name", names);
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

}
