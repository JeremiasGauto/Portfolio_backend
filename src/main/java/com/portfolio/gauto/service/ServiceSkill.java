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
public class ServiceSkill implements IserviceSkill {
    
    @Autowired
    RSkill rSkill;
    
    
 

    @Override
    public List<Skill> getSkills() {
        return rSkill.findAll();
    }

    @Override
    public Skill saveSkill(Skill skill) {
       Skill skilledit= rSkill.save(skill);
       return skilledit;
        
    }

    @Override
    public void deleteSkill(Long Id) {
        rSkill.deleteById(Id);
    }

    @Override
    public Skill findSkill(Long Id) {
       Skill skill= rSkill.findById(Id).orElse(null);
      return skill;
    }
    
    public boolean existsById(Long id){
    return rSkill.existsById(id);
    }
    public Optional<Skill> getOne(Long id){
        return rSkill.findById(id);
    }
    
    
    
    
    
}
