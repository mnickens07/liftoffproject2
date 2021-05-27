package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity{
    private int id;
    private static int nextId=1;

    @NotBlank
    @Size(min=3, max=50)
    private String name;

    @Size(max=500, message="Description too long.")
    private String description;

    private Date date;

    @NotBlank
    @Email(message="Invalid email format.")
    private String contactEmail;

    public Event(String name, String description, Date date, String contactEmail){
        this.name=name;
        this.description=description;
        this.date=date;
        this.contactEmail=contactEmail;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
