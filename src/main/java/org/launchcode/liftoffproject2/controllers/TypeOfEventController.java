package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.TypeOfEventRepository;
import org.launchcode.liftoffproject2.models.TypeOfEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("typeOfEvent")
public class TypeOfEventController {
    @Autowired
    private TypeOfEventRepository typeOfEventRepository;

    @GetMapping
    public String displayAllTypes(Model model){
        model.addAttribute("title","All Sports");
        model.addAttribute("types", typeOfEventRepository.findAll());
        return "typeOfEvent/index";
    }

    @GetMapping("create")
    public String renderCreateTypeForm(Model model) {
        model.addAttribute("title", "Create Sport Type");
        model.addAttribute(new TypeOfEvent());
        return "typeOfEvent/create";
    }

    @PostMapping("create")
    public String processCreateTypeForm(@ModelAttribute @Valid TypeOfEvent typeOfEvent, Model model, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Type");
            model.addAttribute(new TypeOfEvent());
            return "typeOfEvent/create";
        }
        typeOfEventRepository.save(typeOfEvent);
        return "redirect:";
    }

}
