package org.launchcode.liftoffproject2.models;

import org.w3c.dom.events.EventException;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message="This field is required.")
    @Size(max=100)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @NotNull(message="Event type is required.")
    @ManyToOne
    private TypeOfEvent typeOfEvent;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();


    public Event( String name, EventDetails eventDetails, TypeOfEvent typeOfEvent){
        this.name=name;
        this.eventDetails=eventDetails;
        this.typeOfEvent=typeOfEvent;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    public TypeOfEvent getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    @Override
    public String toString() {
        return name;
    }

}
