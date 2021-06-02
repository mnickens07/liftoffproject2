package org.launchcode.liftoffproject2.models;

import org.launchcode.liftoffproject2.data.EventRepository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Event extends AbstractEntity{

    @Id
    @GeneratedValue//generates nextId for me instead of me manually doing it with i++
    private int id;

    @Size(max=500, message="Description too long.")
    private String description;

    @NotNull
    private Date date;

    @NotBlank(message="email is required.")
    @Email(message="Invalid email format.")
    private String contactEmail;

    public Event( String description, Date date, String contactEmail){

        this.description=description;
        this.date=date;
        this.contactEmail=contactEmail;
    }

    public Event() {}

    @Override
    public int getId() {
        return id;
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
