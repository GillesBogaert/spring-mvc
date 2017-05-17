/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.controller;

import com.ip.events.model.Event;
import com.ip.events.service.EventService;
import com.ip.events.validation.UserFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/event")
public class EventsController {

    private final Logger logger = LoggerFactory.getLogger(EventsController.class);
    
    @Autowired
    UserFormValidator validator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }
 
    private EventService service;
    
    @Autowired
    public EventsController(EventService service){
        this.service = service;

    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite. ");
        return "index";
    }

    @RequestMapping(value="/eventOverview", method = RequestMethod.GET)
    public ModelAndView getEvents(){
        return new ModelAndView("events", "events", service.getEvents());
    }
    
    @RequestMapping(value="/addEventPage", method= RequestMethod.GET)
    public String addEventPage(Model model){
        //return new ModelAndView("addEvent", "event", new Event());
        Event event = new Event();
        model.addAttribute("eventForm", event);
        return "addEvent";
    }

    @RequestMapping(value="deleteConfirm/{id}",method=RequestMethod.GET)
    public ModelAndView deleteConfirmation(@PathVariable String id){
        return new ModelAndView("confirmationPage", "event", service.getEvent(id));
    }
    
    @RequestMapping(value="delete/{id}",method=RequestMethod.GET)
    public String deleteEvent(@PathVariable String id){
        service.deleteEvent(id);
        return "redirect:/event/eventOverview.htm";
    }
    
    @RequestMapping(value="edit/{id}",method=RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable String id){
        return new ModelAndView("addEvent", "event", service.getEvent(id));
    }
    
    @RequestMapping(value="/saveEvent", method= RequestMethod.POST)
    public String save(@ModelAttribute("eventForm") @Validated Event event, BindingResult result, Model model){
        System.out.println(result.toString());
        if (result.hasErrors()){
            return "addEvent"; 
        }
        if (service.contains(event)){
            service.update(event);
        }
        else {
            service.addEvent(event);
        }
        return "redirect:/event/eventOverview";
    }

        
}
