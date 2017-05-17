/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.model;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author imgil
 */
@Entity
public class Event {

    private LocalDateTime endDatef;
    private LocalDateTime startDatef;
    private String endDate;
    private String startDate;
    private String name;
    
    @Id
    @GeneratedValue
    private String id;

    public String getId() {
        return id;
    }

    public void setId() {

        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event() {
        
        setId();

    }

    public Event(String endDate, String startDate, String name) {
        setendDate(endDate);
        setstartDate(startDate);
        setEndDatef(endDate);
        setStartDatef(startDate);
        setName(name);
        setId();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setendDate(String endDate) {
        
        this.endDate = endDate;
    }

    public LocalDateTime getEndDatef() {
        return endDatef;
    }

    public void setEndDatef(String endDatef) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.endDatef = LocalDateTime.parse(endDatef, formatter);
        System.out.println(this.getEndDatef());
    }

    public LocalDateTime getStartDatef() {
        return startDatef;
    }

    public void setStartDatef(String startDatef) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
        this.startDatef = LocalDateTime.parse(startDatef, formatter);
        System.out.println(this.getStartDatef());
    }

    public String getStartDate() {
        return startDate;
    }

    public void setstartDate(String startDate) {
            
            this.startDate = startDate;

    }

}
