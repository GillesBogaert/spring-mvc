/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.model;

import java.time.LocalDateTime;


/**
 *
 * @author imgil
 */
public class StudyTime extends Event {
   
   private String vak;
   private String toDo;
   
   public StudyTime(String endDate, String startDate, String name, String toDo, String vak){
       super(endDate, startDate, name);
       setToDo(toDo);
       setVak(vak);
   }
  
    public String getVak() {
        return vak;
    }

    private void setVak(String vak) {
        this.vak = vak;
    }

    public String getToDo() {
        return toDo;
    }

    private void setToDo(String toDo) {
        this.toDo = toDo;
    }  
}
