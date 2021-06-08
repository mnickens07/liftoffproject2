package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class TypeOfEvent extends AbstractEntity {

    @NotBlank(message="This field is required.")
    @Size(max=100)
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
}
