/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.model;

import com.ip.events.model.Event;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author imgil
 */
public class Afspraak extends Event {
    
    private String location;
    private String metPersoon;
    
    public Afspraak(String endDate, String startDate, String name, String location, String metPersoon){
        super(endDate, startDate, name);
        setLocation(location);
        setMetPersoon(metPersoon);
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    public String getMetPersoon() {
        return metPersoon;
    }

    private void setMetPersoon(String metPersoon) {
        this.metPersoon = metPersoon;
    }
    
    
}
