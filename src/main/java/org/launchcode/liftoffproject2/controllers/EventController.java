package org.launchcode.liftoffproject2.controllers;

import org.launchcode.liftoffproject2.data.EventRepository;
import org.launchcode.liftoffproject2.data.TagRepository;
import org.launchcode.liftoffproject2.data.TypeOfEventRepository;
import org.launchcode.liftoffproject2.models.Event;
import org.launchcode.liftoffproject2.models.Tag;
import org.launchcode.liftoffproject2.models.TypeOfEvent;
import org.launchcode.liftoffproject2.models.dto.EventTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository; //methods that come from crudRepository include findAll(), findById(), save()

    @Autowired
    private TypeOfEventRepository typeOfEventRepository;

    @Autowired
    private TagRepository tagRepository;

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

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId){
        Optional<Event> event = eventRepository.findById(eventId);
        model.addAttribute("title", "Edit Event "+event.get().getName()+" (id="+event.get().getId()+")");
        model.addAttribute("event", event.get());
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description,Model model) {
        Optional<Event> result=eventRepository.findById(eventId);
        Event event= result.get();
        event.setName(name);
        event.getEventDetails().setDescription(description);
        eventRepository.save(event);

        model.addAttribute("event",eventRepository.findAll());

        return "redirect:/events";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model) {

        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
            model.addAttribute("tags", event.getTags());
        }

        return "events/detail";
    }

    // responds to /events/add-tag?eventId=13
    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer eventId, Model model){
        Optional<Event> result = eventRepository.findById(eventId);
        Event event = result.get();
        model.addAttribute("title", "Add Tag to: " + event.getName());
        model.addAttribute("tags", tagRepository.findAll());
        EventTagDTO eventTagDTO = new EventTagDTO();
        eventTagDTO.setEvent(event);
        model.addAttribute("eventTagDTO", eventTagDTO);
        return "events/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid EventTagDTO eventTagDTO,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Event event = eventTagDTO.getEvent();
            Tag tag = eventTagDTO.getTag();
            if (!event.getTags().contains(tag)){
                event.addTag(tag);
                eventRepository.save(event);
            }
            return "redirect:detail?eventId=" + event.getId();//events/add-tag?eventId=13
        }

        return "redirect:add-tag";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }

        return "redirect:";
    }


}
