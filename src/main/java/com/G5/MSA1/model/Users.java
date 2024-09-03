/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author premnath
 */
@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String password;
    public String getUsername() {
        return this.username;
    }
    
    
    
    public String getPassword(){
    return this.password;
    }

    public void setUsername(String id) {
        this.username=id;
    }

    public void setPassword(String pass){
    this.password=pass;
    }

   

    @Override
    public String toString() {
        return "com.G5.MSA1.model.Users[ id=" + this.username + " ]";
    }
    
}
