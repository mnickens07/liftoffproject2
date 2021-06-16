package org.launchcode.liftoffproject2.data;

import org.launchcode.liftoffproject2.models.Event;

import java.util.*;

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
    public static void addEvents(Event event){
        events.put(event.getId(), event);
    }

    public static ArrayList<Event> findByColumnAndValue(String column, String value, Iterable<Event> allEvents) {

        ArrayList<Event> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Event>) allEvents;
        }

        if (column.equals("all")){
            results = findByValue(value, allEvents);
            return results;
        }
        for (Event event : allEvents) {

            String aValue = getFieldValue(event, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(event);
            }
        }

        return results;
    }

    public static String getFieldValue(Event event, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = event.getName();
        } else if (fieldName.equals("type")){
            theValue = event.getTypeOfEvent().toString();
        } else {
            theValue = event.getTags().toString();
        }

        return theValue;
    }

    public static ArrayList<Event> findByValue(String value, Iterable<Event> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Event> results = new ArrayList<>();

        for (Event event : allJobs) {

            if (event.getName().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.getTypeOfEvent().toString().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.getTags().toString().toLowerCase().contains(lower_val)) {
                results.add(event);
            } else if (event.toString().toLowerCase().contains(lower_val)) {
                results.add(event);
            }

        }

        return results;
    }

}
