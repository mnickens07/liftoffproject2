package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.models.dto.LoginFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(method ={RequestMethod.GET, RequestMethod.POST}, value="hey") //handles get and post requests of the form /hey?name=Marcus
    public String heyQueryParam(@RequestParam String name, Model model){
        String greeting= "Hey, "+ name+"!!!!!";
        model.addAttribute("greeting", greeting);
        return "hey";
    }

    @GetMapping("hey/{name}")//better way to handle the heyQueryParam method. helloPathParam basically replaces it.
    public String helloPathParam(@PathVariable String name, Model model){
        String greeting = "Hey, " +name+ "!";
        String sayBye = "Goodbye, " +name+"!";
        model.addAttribute("greeting", greeting);
        model.addAttribute("sayBye", sayBye);
        return "hey";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-list")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Marcus");
        names.add("Isaiah");
        names.add("Nickens");
        model.addAttribute("names",names);
        return "hello-list";

    }


}
