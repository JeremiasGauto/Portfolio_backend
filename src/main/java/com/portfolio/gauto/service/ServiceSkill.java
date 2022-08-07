/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Skill;
import com.portfolio.gauto.repository.RSkill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ServiceSkill {
    
    @Autowired
    RSkill rSkill;
    
    
    public List<Skill> list(){
        return rSkill.findAll();
    
    }
    
     public Optional<Skill> getOne (Long id){
        return rSkill.findById(id);
    }
    
   
    
    public void save(Skill skill){
        rSkill.save(skill);
    }
    
    public void delete(Long id){
        rSkill.deleteById(id);
    }
    
    
    
    
    
    
    
}
