/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Proyecto;
import com.portfolio.gauto.repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceProyecto implements Iproyecto{

    @Autowired 
    RProyecto rProyecto;
    
    @Override
    public List<Proyecto> getProyecto() {
        return rProyecto.findAll();
    }

    @Override
    public Proyecto saveProyecto(Proyecto proyecto) {
        Proyecto proyectoEdit= rProyecto.save(proyecto);
         return proyectoEdit;
    }

    @Override
    public void deleteProyecto(Long Id) {
     rProyecto.deleteById(Id);
    }

    @Override
    public Proyecto findProyecto(Long Id) {
       Proyecto proyecto = rProyecto.findById(Id).orElse(null);
       return proyecto;
    }
    
     public boolean existsById(Long id){
    return rProyecto.existsById(id);
    }
    public Optional<Proyecto> getOne(Long id){
        return rProyecto.findById(id);
    }
}
