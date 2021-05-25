package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity{
    private int id;
    private static int nextId=1;

    private String name;
    private String description;
    private Date date;

    public Event(String name, String description, Date date){
        this.name=name;
        this.description=description;
        this.date=date;
        this.id=nextId;
        nextId++;
    }

    @Override
    public int getId() {
        return id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
