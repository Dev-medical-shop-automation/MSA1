/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.service;

import com.G5.MSA1.model.Medicine;
import com.G5.MSA1.repository.medicineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author premnath
 */
@Service
public class medicineService {

    @Autowired
    medicineRepository med_repo;
    
    public Medicine getMedicineById(int id) {
        
        return med_repo.findById(id).orElse(new Medicine());
    }

    
    public List<Medicine> getMedicines() {
    
        return med_repo.findAll();
    }

    
    public Medicine addMedicine(Medicine med) {
        
        return med_repo.save(med);
    }
    
    
    
    public Medicine updateMedicine(Medicine upd_med,int id) {
        System.out.println("id: "+id+" existsById output:"+med_repo.existsById(id));
                
        if (med_repo.existsById(id)){
            System.out.println("updateMedicine @Service if condition");
            Medicine exist_med=getMedicineById(id);
            upd_med.setId(id);
            if (upd_med.getExpDate()==null){
                upd_med.setExpDate(exist_med.getExpDate());
            }
            if (upd_med.getMfgDate()==null){
                upd_med.setMfgDate(exist_med.getMfgDate());
            }
            if (upd_med.getCost()==null){
                upd_med.setCost(exist_med.getCost());
            }
            if (upd_med.getQty()==0){
                upd_med.setQty(exist_med.getQty());
            }
            if (upd_med.getType()==null){
                upd_med.setType(exist_med.getType());
            }
            if (upd_med.getName()==null){
                upd_med.setName(exist_med.getName());
            }
            if (upd_med.getGenericName()==null){
                upd_med.setGenericName(exist_med.getGenericName());
            } 
        }

        else {
            System.out.println("updateMedicine @Service else condition");
            return new Medicine();
        }
        
        med_repo.update(
                upd_med.getId(),
                upd_med.getName(),
                upd_med.getGenericName(),
                upd_med.getMfgDate(),
                upd_med.getExpDate(),
                upd_med.getType(),
                upd_med.getCost(),
                upd_med.getQty()                
        );
        return upd_med;
        
        
        
        
    }

    public List<Medicine> searchMedicine(String key) {
        
    return med_repo.search(key);}

    public Float sellMedicine(int id, int qty) {
                
        int currentStock=getMedicineById(id).getQty();
        int sellingQuantity=qty;
        
        if (currentStock>=sellingQuantity){
            Medicine med=new Medicine(getMedicineById(id));
            //add the record to the salesrecord object and save the record to the database
            med.setQty(currentStock-sellingQuantity);
            updateMedicine(med,id);
            System.out.println(med.getCost());
            float amount=med.getCost();
            
            return amount*qty;
        }
        else{
            return null;
        }
        
    }
}
