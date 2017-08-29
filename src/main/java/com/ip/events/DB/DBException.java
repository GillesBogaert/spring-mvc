/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ip.events.DB;;

/**
 *
 * @author Gilles
 */
public class DBException extends RuntimeException {

	public DBException(String message) {
		super(message);
	}
	
	public DBException(String message, Exception e) {
		super(message, e);
	}
}