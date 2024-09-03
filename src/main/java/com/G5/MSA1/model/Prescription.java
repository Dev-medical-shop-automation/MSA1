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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */
@Component
@Entity
public class Prescription {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private int prescriptionId;
    
    @Column(name="diagnosis")
    private String diagnosis;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor prescriptionDoctorId;
    @OneToMany(mappedBy = "salesPrescription")
    private List<SalesRecord> salesRecordsForThisPrescription;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer prescriptionCustomer;
    
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prescription{");
        sb.append("prescriptionId=").append(prescriptionId);
        sb.append(", diagnosis=").append(diagnosis);
        sb.append(", salesRecordsForThisPrescription=").append(salesRecordsForThisPrescription);
        sb.append(", prescriptionCustomer=").append(prescriptionCustomer);
        sb.append('}');
        return sb.toString();
    }
    
    
    public int getPrescriptionId(){
        return this.prescriptionId;
    }
    public List<SalesRecord> getSalesRecordsForThisPrescription(){
        return this.salesRecordsForThisPrescription;
    }
    public Customer getPrescriptionCustomer(){
        return this.prescriptionCustomer;
    }
    
    
    public void setPrescrioptionId(int id){
        this.prescriptionId=id;
    }
    public void setPrescriptionCustomer(Customer customer){
        this.prescriptionCustomer=customer;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
