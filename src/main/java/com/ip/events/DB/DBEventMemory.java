/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.DB;

import com.ip.events.model.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author imgil
 */
public class DBEventMemory implements DBEvent{
    
    private static Map<String, Event> events = new HashMap<String, Event>();

    public DBEventMemory(){
        LocalDateTime time12 = LocalDateTime.of(2014, Month.JANUARY, 1,0,0);
        LocalDateTime time22 = LocalDateTime.of(2014, Month.JANUARY, 2,0,0);
        LocalDateTime time32 = LocalDateTime.of(2015, Month.APRIL, 23,15,0);
        String time1 = "04/05/1995 11:30";
        String time2 = "03/09/1995 11:45";
        String time3 = "03/06/1995 12:00";
       
        Event event1 = new Afspraak(time1, time2, "Dokter Afspraak", "Leuven", "Dr. Smith");
        Event event2 = new Les(time1, time2, "IP Minor", "C0.16", "IP", "Mieke Kemmens", "Domain classes afwerken");
        Event event3 = new StudyTime(time1, time3, "IP Study session", "Samenvatting theory les 1", "IP");
        
        events.put(event1.getId(), event1);
        events.put(event2.getId(), event2);
        events.put(event3.getId(), event3);
    }
    
    @Override
    public void addEvent(Event event) {
        if (event == null){
            throw new IllegalArgumentException("Event cannot be null");
        }
        if (events.containsKey(event.getId())){
            throw new IllegalArgumentException("Event with id" + event.getId() + " has already been registered");
        }
        events.put(event.getId(), event);
    }

    @Override
    public void removeEvent(String id) {
        if ( id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        else {
            events.remove(id);
        }
    }

    @Override
    public Event getEvent(String id) {
        if ( id == null || id.isEmpty()){
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return events.get(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return new ArrayList<Event>(events.values());
    }

    @Override
    public void removeAllEvents() {
        events.clear();
    }

    @Override
    public void UpdateEvent(Event event) {
         if (event == null){
            throw new IllegalArgumentException("Event cannot be null");
        }
        else {
            events.put(event.getId(), event);
        }
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
