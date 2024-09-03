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
import jakarta.persistence.OneToMany;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */

@Component
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="doctor_id")
    private int doctorId;
    @Column(name = "doctor_name")
    private String doctorName;
    @JsonView(Views.managerView.class)
    @OneToMany(mappedBy = "salesDoctor")
    private List<SalesRecord> salesRecordsOfThisDoctor;
    @OneToMany(mappedBy = "prescriptionDoctorId")
    private List<Prescription> prescriptionsOfDoctor;
    public int getDoctorId(){
        return this.doctorId;
    }
    public String getDoctorName(){
        return this.doctorName;
    }
    public List<SalesRecord> getSalesRecordsOfThisDoctor(){
        return this.salesRecordsOfThisDoctor;
    }
    
    public void setDoctorId(int id){
    this.doctorId=id;
    }
    public void setDoctorName(String name){
    this.doctorName=name;
    }
    
}
