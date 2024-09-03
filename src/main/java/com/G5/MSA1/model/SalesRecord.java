/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.model;


import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Time;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */
@Entity
@Component
public class SalesRecord {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sales_id")
    private int salesRecordId;
    

    @ManyToOne
    @JoinColumn(name="medicine_id")
    private Medicine salesMedicine;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer salesCustomer;
    
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor salesDoctor;
    
    @ManyToOne
    @JoinColumn(name="pharmacist_id")
    private Pharmacist salesPharmacist;
    
    @ManyToOne
    @JoinColumn(name="prescription_id")
    private Prescription salesPrescription;
    
    @Column(name="profit")
    @JsonView(Views.managerView.class)
    private Float profit;
    
    @Column(name = "sales_time")
    private Time salesTime;
    
    
    public int getSalesRecordId(){
        return this.salesRecordId;
    }
    public Medicine getSalesMedicine(){
        return this.salesMedicine;
    }
    public Customer getSalesCustomer(){
        return this.salesCustomer;      //.getCustomerId();
    }
    public Doctor getSalesDoctor(){
        return this.salesDoctor;
    }
    public Pharmacist getSalesPharmacist(){
        return this.salesPharmacist;
    }
    public Prescription getSalesPrescription(){
        return this.salesPrescription;
    }
    @JsonView(Views.managerView.class)
    public Float getProfit(){
        return this.profit;
    }
    public Time getsalesTime(){
        return  this.salesTime;
    }
    
    
    public void setSalesRecordId(int id){
        this.salesRecordId=id;
    }
    public void setSalesMedicine(Medicine med){
        this.salesMedicine=med;
    }
    public void setSalesCustomer(Customer customer){
        this.salesCustomer=customer;
    }
    public void setSalesDoctor(Doctor doc){
        this.salesDoctor=doc;
    }
    public void setSalesPharmacistId(Pharmacist pharmacist){
        this.salesPharmacist=pharmacist;
    }
    public void setSalesPrescription(Prescription prescription){
        this.salesPrescription=prescription;
    }
    public void setSalesTime(Time time){
        this.salesTime=time;
    }
    @JsonView(Views.managerView.class)
    public void profit(float id){
        this.profit=id;
    }
    
    
}
