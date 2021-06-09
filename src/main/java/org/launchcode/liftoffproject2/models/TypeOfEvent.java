package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TypeOfEvent extends AbstractEntity {

    @NotBlank(message="This field is required.")
    @Size(max=100)
    private String name;

    @OneToMany(mappedBy = "typeOfEvent")
    private final List<Event> events = new ArrayList<>();

    public TypeOfEvent(String name){
        this.name=name;
    }

    public TypeOfEvent(){}

    public String getName() {
        return name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setName(String name) {
        this.name = name;
    }
}
