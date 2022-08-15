/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.controller;

import com.portfolio.gauto.Dto.dtoEducacion;
import com.portfolio.gauto.Security.Controller.Mensaje;
import com.portfolio.gauto.entity.Educacion;
import com.portfolio.gauto.service.Seducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    Seducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
    List<Educacion> list= sEducacion.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id"), HttpStatus.NOT_FOUND);
        }
        
        Educacion educacion= sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
           if(!sEducacion.existsById(id)){
               return new ResponseEntity(new Mensaje ("No existe el Id"), HttpStatus.NOT_FOUND);
           }
           sEducacion.delete(id);
           return new ResponseEntity(new Mensaje ("Educacion eliminada"), HttpStatus.OK);
    }
    
   @PostMapping("/create")
   public ResponseEntity<?>create(@RequestBody dtoEducacion dtoeducacion){
       if(StringUtils.isBlank(dtoeducacion.getNombreE())){
           return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       }
       if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())){
           return new ResponseEntity(new Mensaje("El nombre que quiere agregar ya existe"), HttpStatus.BAD_REQUEST);
       }
       Educacion educacion= new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE(), dtoeducacion.getimgEducacion());
       sEducacion.save(educacion);
       return new ResponseEntity(new Mensaje("Educacion incorporada"), HttpStatus.OK);
       
   }
    
   @PutMapping("/edit")
    public ResponseEntity<Educacion>editarProyecto(@RequestBody Educacion educacion){
        Educacion updateEducacion=sEducacion.saveEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);   
 }
    
    
    
    
}
