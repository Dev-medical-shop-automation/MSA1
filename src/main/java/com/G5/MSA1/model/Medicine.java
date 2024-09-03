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
import jakarta.persistence.OneToMany;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author premnath
 */

    
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author premnath
 * This is the Medicine object in our project MSA
 * three types of constructors, one with no args,one with all args, one with another medicine object/Entity
 * 
 */
@Component
@Entity

public class Medicine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="medicine_id")
    private int medicineId;
    @Column(name="name")
    private String name;
    @Column(name="generic_name")
    private String genericName;
    @Column(name="mfg_date")
    private Date mfgDate;
    @Column(name="exp_date")
    private Date expDate;
    @Column(name="type")
    private String type;
    @Column(name="cost")
    private Float cost;
    @Column(name="qty")
    private int qty;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    @JsonView(Views.supplierView.class)
    private Supplier medicineSupplier;
   
    @OneToMany(mappedBy = "salesMedicine")
    @JsonView(Views.pharmacistView.class)
    private List<SalesRecord> salesRecordsOfThisMedicine;
            
    public Medicine(Medicine med){
        this.name=med.name;
        this.medicineId=med.medicineId;
        this.genericName=med.genericName;
        this.mfgDate=med.mfgDate;
        this.expDate=med.expDate;
        this.type=med.type;
        this.cost=med.cost;
        this.qty=med.qty;
    }
    
    public Medicine(){}
    
    
    public Medicine(int mid,String name,String genericName,Date mfgDate,Date expDate,String type,Float cost,int qty){
        this.medicineId=mid;
        this.name=name;
        this.genericName=genericName;
        this.mfgDate=mfgDate;
        this.expDate=expDate;
        this.type=type;
        this.cost=cost;
        this.qty=qty;

    }
    
    
    
    public int getId(){
        return this.medicineId;
    }  
    public String getName(){
        return this.name;
    }
    public String getGenericName(){
        return this.genericName;
    }
    public Date getMfgDate(){
        return this.mfgDate;
    }
    public Date getExpDate(){
        return this.expDate;
    }
    public int getQty(){
        return this.qty;
    }
    public Float getCost(){
        return this.cost;
    }
    public String getType(){
        return this.type;
    }
    public Supplier getMedicineSupplier(){
        return this.medicineSupplier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medicine{");
        sb.append("medicineId=").append(medicineId);
        sb.append(", name=").append(name);
        sb.append(", genericName=").append(genericName);
        sb.append(", mfgDate=").append(mfgDate);
        sb.append(", expDate=").append(expDate);
        sb.append(", type=").append(type);
        sb.append(", cost=").append(cost);
        sb.append(", qty=").append(qty);
        sb.append(", medicineSupplier=").append(medicineSupplier);
        sb.append(", salesRecordsOfThisMedicine=").append(salesRecordsOfThisMedicine);
        sb.append('}');
        return sb.toString();
    }
    public List<SalesRecord> getSalesRecordsOfThisMedicine(){
        return this.salesRecordsOfThisMedicine;
    }
    
    
    
    public void setName(String name){
        this.name=name;
    }
    public void setGenericName(String genName){
        this.genericName=genName;
    }
    public void setMfgDate(Date date){
        this.mfgDate=date;
    }
    public void setExpDate(Date date){
        this.expDate=date;
    }
    public void setQty(int qt){
        this.qty=qt;
    }
    public void setCost(Float cost){
        this.cost=cost;
    }
    public void setType(String type){
        this.type=type;
    }

    public void setId(int id) {
        this.medicineId=id;
    }
    public void setMedicineSupplier(Supplier supplier){
        this.medicineSupplier=supplier;
    }
   
}





