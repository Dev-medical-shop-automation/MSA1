/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G5.MSA1.controller;

import com.G5.MSA1.model.Medicine;
import com.G5.MSA1.service.medicineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author premnath
 */

@RestController
@CrossOrigin
@RequestMapping("/")
@Component
public class medicineController {
    
    @Autowired
    medicineService service;
    
    @GetMapping("/{id}")
    
    public ResponseEntity<Medicine> getMedicine(@PathVariable int id) throws JsonProcessingException{
        
        Medicine med=service.getMedicineById(id);
        System.out.println("Get medicine with {id}:"+med.toString());
        

        return new ResponseEntity<>(med,HttpStatus.FOUND);
        
    }
    
    
    @GetMapping("/")
    
    public ResponseEntity<List<Medicine>> getMedicines(){
        
        ResponseEntity<List<Medicine>> response;
        response = new ResponseEntity<>(service.getMedicines(),HttpStatus.OK);
        System.out.println("home:Get all medicines:"+response);
       
        return response;
        
    }
    
    
    @PostMapping("/add_med")
    
    public ResponseEntity<Medicine> postMedicine(@RequestBody Medicine med){
        System.out.println("The RequestBody:"+med);
        return ResponseEntity.ok(service.addMedicine(med));
    }
    
    
    @PostMapping("/search")
    
    public ResponseEntity<List<Medicine>> search(@RequestBody String key){
        System.out.println("keyword:"+key);
        return new ResponseEntity<>(service.searchMedicine(key),HttpStatus.FOUND);
    } 
    
    
    @PutMapping("/update_medicine/{id}")
    
    public ResponseEntity<Medicine> putMedicine(@RequestBody Medicine med,@PathVariable int id,HttpServletRequest req){
        System.out.println("update medicine:"+med.toString());
        req.getAttribute("_csrf");
        return ResponseEntity.ok(service.updateMedicine(med,id));
    }
    
    
    @PostMapping("/sell_medicine/{id}")
    
    public ResponseEntity<Float> sellMedicine(@RequestBody Medicine med,@PathVariable int id){
        System.out.println("Sell Medicine id:"+med.getId());
        Float cost=service.sellMedicine(id,med.getQty());
        if (cost!=null){
            return new ResponseEntity(cost,HttpStatus.ACCEPTED);
        }
        else{
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}
