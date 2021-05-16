package org.launchcode.liftoffproject2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String index(Model model){
        String greeting = "Hey, World!";
        model.addAttribute("greeting",greeting);

        return "index";
    }

}
