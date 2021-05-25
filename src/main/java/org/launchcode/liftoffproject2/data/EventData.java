package org.launchcode.liftoffproject2.data;

import org.launchcode.liftoffproject2.models.Event;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    //need a place to put events
    private static final Map<Integer, Event> events = new HashMap<>();

    //get all events
    public static Collection<Event> getAll() {
        return events.values();

    }

    //add a single event
    public static Event getEventById(Integer id){
        return events.get(id);
    }

    //add an event
    public static void addEvent(Event event){
        events.put(event.getId(), event);
    }
    //remove an event
    public static void remove(Integer id) {
        if(events.containsKey(id)){
            events.remove(id);
        }

    }
}
