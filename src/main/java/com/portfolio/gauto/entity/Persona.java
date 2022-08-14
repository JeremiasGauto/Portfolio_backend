
package com.portfolio.gauto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;




@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
        
    
    private String img;
    
    private String acercaDe;
    
    private String bannerPersonal;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String acercaDe, String bannerPersonal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
        this.bannerPersonal = bannerPersonal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }

    public String getBannerPersonal() {
        return bannerPersonal;
    }

    public void setBannerPersonal(String bannerPersonal) {
        this.bannerPersonal = bannerPersonal;
    }
    
    
    
    
    
}
