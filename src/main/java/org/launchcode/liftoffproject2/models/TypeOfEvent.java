package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class TypeOfEvent extends AbstractEntity {

    @NotBlank(message="name is required.")
    @Size(min=3, max=50)
    private String name;

    public TypeOfEvent(String name){
        this.name=name;
    }

    public TypeOfEvent(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
