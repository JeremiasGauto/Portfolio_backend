/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Skill;
import java.util.List;

/**
 *
 * @author EXE
 */
public interface IserviceSkill {
    
      public List <Skill>getSkills();
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long Id);
    
    public Skill findSkill(Long Id);
    
}
