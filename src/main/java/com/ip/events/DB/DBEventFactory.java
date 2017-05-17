/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.DB;

public class DBEventFactory {

    public DBEvent createDatabase(String choice) {
        DBEvent db = null;
        if (choice.equals("Memory")) {
            db = new DBEventMemory();
        }
        if (choice.equals("JPA")){
            db = new EventJpaDatabase();
        }
        else {
            //db = new DBEventSQL();
        }
        db = new DBEventMemory();
        return db;
    }

}
