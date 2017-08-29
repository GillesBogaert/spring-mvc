/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.service;

import com.ip.events.model.Event;
import java.util.List;

/**
 *
 * @author Gilles
 */
public interface Service {

    public Event getEvent(String id);

    public List<Event> getEvents();

    public void addEvent(Event event);

    public void update(Event event);

    public void deleteEvent(String id);

    public boolean contains(Event event);

}
