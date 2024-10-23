/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.fdcweb.repository;

import com.nnt.fdcweb.model.WpTable1;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WpTable1Repository extends CrudRepository<WpTable1, Integer> {

    @Query(name = "WpTable1.findByFullname")
    List<WpTable1> findByFullname(String fullname);
}
