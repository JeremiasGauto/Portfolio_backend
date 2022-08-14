/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Persona;
import java.util.List;

/**
 *
 * @author EXE
 */
public interface IPersonaService {
    
    public List <Persona>getPersonas();
    
    public Persona savePersona(Persona pers);
    
    public void deletePersona(Long Id);
    
    public Persona findPersona(Long Id);
    
   
    
}
