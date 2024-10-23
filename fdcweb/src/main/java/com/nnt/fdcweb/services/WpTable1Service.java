/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nnt.fdcweb.services;

import com.nnt.fdcweb.model.WpTable1;
import java.util.List;

public interface WpTable1Service {

    Iterable<WpTable1> findAll();

    WpTable1 findById(Integer id);

    void insert(WpTable1 wpTable1);
    
    void update(WpTable1 wpTable);
    
    void deleteById(Integer id);
    
    List<WpTable1> findByFullname(String fullname);
}
