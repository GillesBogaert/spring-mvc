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

    private EntityManagerFactory emfactory;
    private EntityManager entityManager;

    public EventJpaDatabase() {

        emfactory = Persistence.createEntityManagerFactory("IP_Event");
        System.out.println("Entity factory succesfully created");
        entityManager = emfactory.createEntityManager();
    }

    @PreDestroy
    @Override
    public void close() {
        emfactory.close();
    }


    @Override
    public void addEvent(Event event) {
        System.out.println("Adding event with id: " + event.getId());
            entityManager.getTransaction().begin();
            entityManager.persist(event);
            entityManager.getTransaction().commit();

    }

    @Override
    public void removeEvent(String id) {
        System.out.println("Removing event with id: " + id);
            Event event = entityManager.find(Event.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(event);
            entityManager.getTransaction().commit();
    }

    @Override
    public void UpdateEvent(Event event) {
        System.out.println("Updating event with id " + event.getId());
            entityManager.getTransaction().begin();
            Event event1 = entityManager.find(Event.class, event.getId());

            event1.setName(event.getName());
            event1.setstartDate(event.getStartDate());
            event1.setendDate(event.getEndDate());
            event1.setId(event.getId());
            entityManager.getTransaction().commit();
    }

    @Override
    public Event getEvent(String id) {
        Event event = null;
        event = entityManager.find(Event.class, id);
        return event;

    }

    @Override
    public List<Event> getAllEvents() {
        List<Event> events = null;
        events = entityManager.createQuery("Select c from Event c", Event.class).getResultList();
        System.out.println(events);
        return events;
    }

    @Override
    public void removeAllEvents() {
            entityManager.getTransaction().begin();
            int deletedCount = entityManager.createQuery("DELETE FROM Event c").executeUpdate();
            System.out.println(deletedCount + " events were deleted");
            entityManager.getTransaction().commit();
    }
}
