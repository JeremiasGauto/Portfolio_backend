/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.controller;

import com.portfolio.gauto.entity.Skill;
import com.portfolio.gauto.service.ServiceSkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")

public class CSkill {
    
@Autowired
ServiceSkill serviceSkill;
    
@GetMapping("/lista")
public ResponseEntity<List<Skill>> listSkill(){
        List<Skill> list= serviceSkill.getSkills();
        return new ResponseEntity(list, HttpStatus.OK);
    }

@PostMapping ("/nueva")
    public void createSkill(@RequestBody Skill skill){
    serviceSkill.saveSkill(skill);
    }


@PutMapping("/edit/skill/{id}")
    public Skill editSkill(@PathVariable Long id,
                                @RequestParam( "nombreSkill") String nuevoNombre,
                                @RequestParam( "fotoSkill") String nuevaFoto,
                                @RequestParam( "porcentaje") Integer nuevoPorcentaje){
    
        Skill skill= serviceSkill.findSkill(id);
        
        skill.setNombreSkill(nuevoNombre);
        skill.setFotoSkill(nuevaFoto);
        skill.setPorcentaje(nuevoPorcentaje);
         
        serviceSkill.saveSkill(skill);
        
        return skill;
    };
    
    @DeleteMapping("/delete/skill/{id}")
    public void deleteSkill(@PathVariable Long id){
        serviceSkill.deleteSkill(id);
    }





}
