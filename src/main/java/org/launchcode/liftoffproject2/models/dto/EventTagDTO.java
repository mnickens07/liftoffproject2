package org.launchcode.liftoffproject2.models.dto;

import org.launchcode.liftoffproject2.models.Event;
import org.launchcode.liftoffproject2.models.Tag;

import javax.validation.constraints.NotNull;

public class EventTagDTO {//use data transfer objects to pass around a tag and event together in a bundle

    @NotNull
    private Event event;

    @NotNull
    private Tag tag;

    public EventTagDTO() {}

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
