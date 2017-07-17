package com.ip.events.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.ip.events.model.Event;
import com.ip.events.service.EventService;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author imgil
 */
public class SmokeTest {
    
    
    private String date1;
    private String date2;
    private LocalDateTime date3;
    private LocalDateTime date4;
    EventService service = new EventService("test");
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        String date1 = "2016-03-04 11:30";
        String date2 = "2016-03-04 11:32";
        LocalDateTime date3 = LocalDateTime.of(2014, Month.JANUARY, 1,0,0);
        LocalDateTime date4 = LocalDateTime.of(2014, Month.JANUARY, 2,0,0);
        service.deleteAll();
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void add_corrent_event_no_errors(){
        Event event = new Event(date2, date1,"test");
        
        service.addEvent(event);
        assertEquals(event, service.getEvent(event.getId()));        
    }
    
    @Test
    public void remove_event_no_errors(){
        Event event = new Event(date2, date1,"test");
        service.addEvent(event);
        service.deleteEvent(event.getId());
        assertTrue(service.getDB().getAllEvents().isEmpty());
    }
    @Test
    public void update_event_no_errors(){
        Event event = new Event(date2, date1,"test");
        Event event2 = new Event(date2, date1,"testing");
        service.addEvent(event);
        service.update(event2);
        assertEquals(event2, service.getEvent(event2.getId()));
        
    }
    
    @Test
    public void get_event_no_errors(){
        Event event = new Event(date2, date1,"test");
        service.addEvent(event);
        assertEquals(event, service.getEvent(event.getId()));
    }

}
