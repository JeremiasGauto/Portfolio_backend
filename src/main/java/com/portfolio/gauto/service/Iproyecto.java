/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.gauto.service;

import com.portfolio.gauto.entity.Proyecto;
import java.util.List;

/**
 *
 * @author EXE
 */
public interface Iproyecto {
    
    public List <Proyecto>getProyecto();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long Id);
    
    public Proyecto findProyecto(Long Id);
    
}
