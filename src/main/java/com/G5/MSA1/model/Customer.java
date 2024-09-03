/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.model;

import jakarta.persistence.Column;
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
@Entity
@Component
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @OneToMany(mappedBy = "salesCustomer")
    private List<SalesRecord> salesRecordsOfThisCustomer;
    
    @OneToMany(mappedBy = "prescriptionCustomer")
    private List<Prescription> prescriptionsOfThisCustomer;
    
    
    public void setCustomerId(int id) {
        this.customerId=id;
    }

    public int getCustomerId() {
        return this.customerId;
    }
    public List<SalesRecord> getSalesRecordsOfThisCustomer() {
        return this.salesRecordsOfThisCustomer;
    }
    public List<Prescription> getPrescriptionsOfThisCustomer(){
        return this.prescriptionsOfThisCustomer;
    }
    
}
