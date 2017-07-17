/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.controller;

import com.ip.events.model.Event;
import com.ip.events.service.EventService;
import com.ip.events.validation.UserFormValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/event")
public class EventsController {

    @Autowired
    UserFormValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    private EventService service;

    @Autowired
    public EventsController(EventService service) {
        this.service = service;

    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
        return "index";
    }

    @RequestMapping(value = "/eventOverview", method = RequestMethod.GET)
    public ModelAndView getEvents() {
        return new ModelAndView("events", "events", service.getEvents());
    }

    @RequestMapping(value = "/addEventPage", method = RequestMethod.GET)
    public String addEventPage(Model model) {
        //return new ModelAndView("addEvent", "event", new Event());
        Event event = new Event();
        model.addAttribute("eventForm", event);
        return "addEvent";
    }

    @RequestMapping(value = "deleteConfirm/{id}", method = RequestMethod.GET)
    public ModelAndView deleteConfirmation(@PathVariable String id) {
        return new ModelAndView("confirmationPage", "event", service.getEvent(id));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteEvent(@PathVariable String id) {
        service.deleteEvent(id);
        return "redirect:/event/eventOverview.htm";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getEditForm(Model model, @PathVariable String id) {
        Event event = service.getEvent(id);
        System.out.println("Editing event with value " + event.getId());
        model.addAttribute("eventForm", event);
        return "addEvent";
    }

    @RequestMapping(value = "/saveEvent", method = RequestMethod.POST)
    public String save(@ModelAttribute("eventForm") @Validated Event event, BindingResult result, Model model) {
        System.out.println("Saving event with value" + event.getId());
        if (result.hasErrors()) {
            return "addEvent";
        }
        if (service.contains(event)){
            service.update(event);
        }
        else {
            service.addEvent(event);
        }
        //service.deleteAll();
        return "redirect:/event/eventOverview";
    }

    public EventService getService() {
        return this.service;
    }
    


    /* REST */
    @RequestMapping(value = "/rest/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getUser() {
        System.out.println("Fetching all Events");
        List<Event> events = service.getEvents();
        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);

    }

    @RequestMapping(value = "/rest/getevent/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {
        System.out.println("Fetching User with id " + id);
        Event event = service.getEvent(id);
        if (event == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/createevent/", method = RequestMethod.POST)
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

    @RequestMapping(value = "/rest/updateevent/{id}", method = RequestMethod.PUT)
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

    @RequestMapping(value = "/rest/deleteevent/{id}", method = RequestMethod.DELETE)
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
