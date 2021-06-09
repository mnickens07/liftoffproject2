package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.data.TypeOfEventRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.launchcode.liftoffproject2.models.TypeOfEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository; //methods that come from crudRepository include findAll(), findById(), save()

    @Autowired
    private TypeOfEventRepository typeOfEventRepository;

    @GetMapping
    public String displayAllEvents(@RequestParam(required = false) Integer typeId, Model model) {
        if(typeId==null){
            model.addAttribute("title", "All Events");
            model.addAttribute("events", eventRepository.findAll());
        } else {
            Optional<TypeOfEvent> result = typeOfEventRepository.findById(typeId);
            if(result.isEmpty()){
                model.addAttribute("title", "Invalid type id:" + typeId);
            } else {
                TypeOfEvent type = result.get();
                model.addAttribute("title", "Events of this type: " + type.getName());
                model.addAttribute("events", type.getEvents());
            }
        }
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Sporting Event");
        model.addAttribute(new Event());
        model.addAttribute("types", typeOfEventRepository.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Event");
            model.addAttribute("dateErrorMsg", "Invalid date format MM/DD/YY");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }




}
