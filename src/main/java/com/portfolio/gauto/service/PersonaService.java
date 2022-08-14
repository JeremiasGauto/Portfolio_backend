/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Persona;
import com.portfolio.gauto.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    public IPersonaRepository persRepo;

    
    @Override
    public List<Persona> getPersonas() {
        return persRepo.findAll();
        
    }

 
    
    public Persona savePersona(Persona persona) {
       Persona PersonaEdit= persRepo.save(persona);
       return PersonaEdit;
        
    }

    @Override
    public void deletePersona(Long Id) {
       persRepo.deleteById(Id);
    }

    @Override
    public Persona findPersona(Long Id) {
      Persona persona= persRepo.findById(Id).orElse(null);
      return persona;
    }

    
    
}
