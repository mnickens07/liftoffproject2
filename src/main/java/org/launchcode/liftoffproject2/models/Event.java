package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Event extends AbstractEntity{

    private String name;
    private String description;
    private Date date;

    public Event(String name, String description, Date date){
        this.name=name;
        this.description=description;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return name;
    }
}
