package org.launchcode.liftoffproject2.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.Date;

@Entity
public class EventDetails extends AbstractEntity{

    @Size(max=500, message="Description too long.")
    private String description;

    @NotNull
    private Date date;

    @NotBlank(message="email is required.")
    @Email(message="Invalid email format.")
    private String contactEmail;

    @NotBlank(message="Location is required.")
    private String location;

    @NotNull(message = "Time is required.")
    private Time time;

    public EventDetails(String description, Date date, String contactEmail, String location, Time time) {
        this.description = description;
        this.date = date;
        this.contactEmail = contactEmail;
        this.location = location;
        this.time = time;
    }

    public EventDetails() {}

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
