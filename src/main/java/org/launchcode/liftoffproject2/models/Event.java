package org.launchcode.liftoffproject2.models;

import org.launchcode.liftoffproject2.data.EventRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity{

    @Size(max=500, message="Description too long.")
    private String description;

    @NotNull
    private Date date;

    @NotBlank(message="email is required.")
    @Email(message="Invalid email format.")
    private String contactEmail;

    @NotNull(message="Event type is required.")
    @ManyToOne
    private TypeOfEvent typeOfEvent;


    public Event( String description, Date date, String contactEmail,TypeOfEvent typeOfEvent){

        this.description=description;
        this.date=date;
        this.contactEmail=contactEmail;
        this.typeOfEvent=typeOfEvent;
    }

    public Event() {}


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

    public TypeOfEvent getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(TypeOfEvent typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }
}
