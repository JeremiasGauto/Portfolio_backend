/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    private String imgExperiencia;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String imgExperiencia) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgExperiencia=imgExperiencia;
        
        
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
     public String getImgExperiencia() {
        return imgExperiencia;
    }

    public void setImgExperiencia(String imgExperiencia) {
        this.imgExperiencia = imgExperiencia;
    }
    
    
}
