/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.service;

import com.ip.events.model.Event;
import com.ip.events.DB.DBEvent;
import com.ip.events.DB.DBEventFactory;
import com.ip.events.DB.DBEventMemory;
import java.util.List;

/**
 *
 * @author Gilles
 */
public class EventService {
    
    private DBEvent db;
    private DBEventFactory factory;
    
    public EventService(String choice){
        factory = new DBEventFactory();
        this.db = factory.createDatabase(choice); 
    }
    
    public Event getEvent(String id){
        return db.getEvent(id);
    }
    public List<Event> getEvents(){
        return db.getAllEvents();
    }
    public void addEvent(Event event){
        db.addEvent(event);
    }
    public void update(Event event){
        db.UpdateEvent(event);
    }
    public void deleteEvent(String id){
        db.removeEvent(id);
    }
    public DBEvent getDB(){
        return db;
    }
    
    public void close(){
        
    }
    
    
    
    
    
    public void deleteAll(){
        db.removeAllEvents();
    }
    
    
    

    public boolean contains(Event event) {
        boolean outcome = true;
        if (db.getEvent(event.getId()) == null){
            outcome = false;
        }
        return outcome;
    }

}
