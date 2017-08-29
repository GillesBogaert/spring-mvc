/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.controller;

import com.ip.events.model.Event;
import com.ip.events.service.Service;
import com.ip.events.validation.UserFormValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/rest")
public class RESTController {

    @Autowired
    UserFormValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @Autowired
    Service service;

    @RequestMapping(value = {"/", "/resthome"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
        return "restAPI";
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUser() {
        System.out.println("Fetching all Events");
        List<Event> events = service.getEvents();
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);

    }

    @RequestMapping(value = "/getevent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {
        System.out.println("Fetching User with id " + id);
        Event event = service.getEvent(id);
        if (event == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/createevent/", method = RequestMethod.POST)
    public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + event.getName());

        if (service.contains(event)) {
            System.out.println("An Event with name " + event.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        service.addEvent(event);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/getevent/{id}").buildAndExpand(event.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/updateevent/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Event> updateEvent(@PathVariable("id") String id, @RequestBody Event event) {
        System.out.println("Updating Event with id " + id);

        Event currentEvent = service.getEvent(id);

        if (currentEvent == null) {
            System.out.println("Event with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }

        currentEvent.setName(event.getName());
        currentEvent.setendDate(event.getEndDate());
        currentEvent.setStartDatef(event.getStartDate());

        service.update(currentEvent);
        return new ResponseEntity<Event>(currentEvent, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteevent/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEventRest(@PathVariable("id") String id) {
        System.out.println("Fetching & Deleting User with id " + id);

        Event event = service.getEvent(id);
        if (event == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }

        service.deleteEvent(id);
        return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
    }

}
