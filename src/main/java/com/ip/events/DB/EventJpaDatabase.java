/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.DB;

import com.ip.events.model.Event;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author imgil
 */
public class EventJpaDatabase implements DBEvent {

    
    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("IP_Event");
    private EntityManager entityManager = emfactory.createEntityManager();
    
    
    public EventJpaDatabase(){
        
        
    }
    
    @PreDestroy
    @Override
    public void close()
    {
        emfactory.close();
    }
    
    
    @Override
    public void addEvent(Event event) {
        entityManager.getTransaction().begin();
        entityManager.persist(event);
        entityManager.getTransaction().commit();
    }

    @Override
    public void removeEvent(String id) {
        Event event = entityManager.find(Event.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(event);
        entityManager.getTransaction().commit();
    }

    @Override
    public Event getEvent(String id) {
        Event event = entityManager.find(Event.class, id);
        return event;
               
    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = entityManager.createQuery("Select c from Event c", Event.class).getResultList();
        return events;
    }

    @Override
    public void removeAllEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateEvent(Event event) {
        Event event1 = entityManager.find(Event.class, event.getId());
        entityManager.getTransaction().begin();
        event1.setName(event.getName());
        event1.setstartDate(event.getStartDate());
        event1.setendDate(event.getEndDate());
        entityManager.getTransaction().commit();
        
    }
    
}
