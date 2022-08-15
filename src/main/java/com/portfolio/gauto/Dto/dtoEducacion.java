/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.gauto.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    
    private String imgEducacion;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String imgEducacion) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.imgEducacion= imgEducacion;
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

    public void setDescripcionE(String imgEducacion) {
        this.descripcionE = descripcionE;
    }
    
     public String getimgEducacion() {
        return imgEducacion;
    }

    public void setimgEducacion(String imgEducacion) {
        this.imgEducacion = imgEducacion;
    }
    
}
