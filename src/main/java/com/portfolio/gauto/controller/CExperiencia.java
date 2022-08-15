/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.controller;

import com.portfolio.gauto.Dto.dtoExperiencia;
import com.portfolio.gauto.Security.Controller.Mensaje;
import com.portfolio.gauto.entity.Experiencia;
import com.portfolio.gauto.service.ServExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "https://portfolio-jeremiasgauto.web.app")
public class CExperiencia {
    
    @Autowired
    ServExperiencia servExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list= servExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoExp){
        if(StringUtils.isBlank(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
        if(servExperiencia.existsByNombreE(dtoExp.getNombreE()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST); 
    
        Experiencia experiencia = new Experiencia(dtoExp.getNombreE(),dtoExp.getDescripcionE(),dtoExp.getImgExperiencia());
        servExperiencia.saveExperiencia(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
          
    }
    
    @PutMapping("/edit")
    public ResponseEntity<Experiencia>editarExperiencia(@RequestBody Experiencia experiencia){
        Experiencia updateExperiencia=servExperiencia.saveExperiencia(experiencia);
        return new ResponseEntity<>(updateExperiencia, HttpStatus.OK);   
 } 
     
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<?> delete(@PathVariable("id")int id){
         if(!servExperiencia.existsById(id))
             return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST); 
         
         servExperiencia.delete(id);
         
         return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK); 
     }
     
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!servExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = servExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
     
}
