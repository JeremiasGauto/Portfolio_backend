/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.controller;

import com.portfolio.gauto.Security.Controller.Mensaje;
import com.portfolio.gauto.entity.Proyecto;
import com.portfolio.gauto.service.ServiceProyecto;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("proyecto")

public class CProyecto {
    
    @Autowired
    ServiceProyecto serviceProyecto;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> listProyecto(){
        List<Proyecto> list= serviceProyecto.getProyecto();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping ("/nuevo")
    public void createProyecto(@RequestBody Proyecto proyecto){
    serviceProyecto.saveProyecto(proyecto);
    }
    
    
    @PutMapping("/edit")
    public ResponseEntity<Proyecto>editarProyecto(@RequestBody Proyecto proyecto){
        Proyecto updateProyecto=serviceProyecto.saveProyecto(proyecto);
        return new ResponseEntity<>(updateProyecto, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/proyecto/{id}")
    public void deleteProyecto(@PathVariable Long id){
        serviceProyecto.deleteProyecto(id);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
        if(!serviceProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = serviceProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);


            }
    
    
    
    
}
