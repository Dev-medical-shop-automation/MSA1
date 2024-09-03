/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */

@Component
@Entity
public class Pharmacist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pharmacist_id")
    private int pharmacistId;
    @Column(name="pharmacist_name")
    private String pharmacistName;
    @Embedded
    private Details pharmacistDetails;
    
    
    @OneToMany(mappedBy = "salesPharmacist")
    private List<SalesRecord> salesRecordsOfThisPharmacist;
    
    
    public int getPharmacistId(){
        return this.pharmacistId;
    }
    public String getPharmacistName(){
        return this.pharmacistName;
    }
    public List<SalesRecord> getSalesRecords(){
        return this.salesRecordsOfThisPharmacist;
    }
    public Details getDetails(){
        return this.pharmacistDetails;
    }
    
    public void setPharmacistId(int id){
        this.pharmacistId=id;
    }
    public void setPharmacistName(String name){
        this.pharmacistName=name;
    }
    @Embeddable
    private static class Details {
        
        public int contact;
        public Details() {
        }
    }
}
