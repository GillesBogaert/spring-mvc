/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
    
    @Autowired
    private MessageSource messageSource;
    
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(Locale locale, ModelMap model) {
        
        // add parametrized message from controller
        String welcome = messageSource.getMessage("valid.id", new Object[]{"John Doe"}, locale);
        model.addAttribute("message", welcome);
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", "10:30");
        
        
        return "index";
    }
    
}
