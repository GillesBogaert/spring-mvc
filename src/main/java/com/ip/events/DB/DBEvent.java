/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.DB;

import com.ip.events.model.Event;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imgil
 */
public interface DBEvent {
    
    public void addEvent(Event event);
    public void removeEvent(String id);
    public Event getEvent(String id);
    public List<Event> getAllEvents();
    public void removeAllEvents();
    public void UpdateEvent(Event event);
    public void close();

    
}
