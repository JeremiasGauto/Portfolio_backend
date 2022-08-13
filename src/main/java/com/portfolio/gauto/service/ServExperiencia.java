/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Experiencia;
import com.portfolio.gauto.repository.RExperiencia;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServExperiencia {
    @Autowired
    RExperiencia rExperiencia;
    
    public List<Experiencia> list(){
        return rExperiencia.findAll();
    
    }
    
    public Optional<Experiencia> getOne (int id){
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE){
        return rExperiencia.findByNombreE(nombreE);
    }
    
    
    public Experiencia saveExperiencia(Experiencia experiencia) {
       Experiencia experienciaEdit= rExperiencia.save(experiencia);
       return experienciaEdit;
        
    }
    
    public Experiencia editarExperiencia(Experiencia experiencia){
    return rExperiencia.save(experiencia); 
            }
    
    public void delete(int id){
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
    return rExperiencia.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
    return rExperiencia.existsByNombreE(nombreE);
    }
    
  
    
}
