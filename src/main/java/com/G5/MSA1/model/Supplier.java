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
import jakarta.persistence.OneToOne;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */
@Component
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="supplier_id")
    private int supplierId;
    @OneToMany(mappedBy = "medicineSupplier")
    private List<Medicine> suppliedMedicines;
    
    
    public int getSupplierId(){
        return this.supplierId;
    }
    public List<Medicine> getSuppliedMedcines(){
        return this.suppliedMedicines;
    }
    
    public void setSupplierId(int id){
        this.supplierId=id;
    }
    
}
