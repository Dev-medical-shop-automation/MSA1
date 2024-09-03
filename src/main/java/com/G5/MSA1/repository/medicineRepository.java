/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.G5.MSA1.repository;

import com.G5.MSA1.model.Medicine;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author premnath
 */
@Repository
public interface medicineRepository extends JpaRepository<Medicine,Integer>{

    @Modifying
    @Transactional
    @Query("UPDATE Medicine m SET "
            + "m.name=:name,"
            + "m.genericName=:genericName,"
            + "m.mfgDate=:mfgDate,"
            + "m.expDate=:expDate,"
            + "m.type=:type,"
            + "m.cost=:cost,"
            + "m.qty=:qty "
            + "WHERE m.id=:id")
    void update(int id, String name, String genericName, Date mfgDate, Date expDate, String type, Float cost, int qty);

   
    @Query("SELECT m FROM Medicine m WHERE "
            + "LOWER(m.name) LIKE LOWER(CONCAT('%', :key,'%')) OR "
            + "LOWER(m.genericName) LIKE LOWER(CONCAT('%', :key,'%')) OR "
            + "LOWER(m.type) LIKE LOWER(CONCAT('%', :key,'%'))")
    List<Medicine> search(String key);
}
