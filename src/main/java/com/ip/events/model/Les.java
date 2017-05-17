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
public class Les extends Event {
    
    private String lokaal;
    private String docent;
    private String teDoen;
    private String vak;

    public String getVak() {
        return vak;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    
    public Les(String endDate, String startDate, String name, String lokaal, String vak, String docent, String teDoen){
        super(endDate, startDate, name);
        setVak(vak);
        setDocent(docent);
        setLokaal(lokaal);
        setTeDoen(teDoen);
    }
    
    public String getLokaal() {
        return lokaal;
    }

    private void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public String getDocent() {
        return docent;
    }

    private void setDocent(String docent) {
        this.docent = docent;
    }

    public String getTeDoen() {
        return teDoen;
    }

    private void setTeDoen(String teDoen) {
        this.teDoen = teDoen;
    }
    
    
}
