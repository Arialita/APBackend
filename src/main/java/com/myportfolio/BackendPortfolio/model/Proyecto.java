package com.myportfolio.BackendPortfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_proyecto;
    
    @Size(max=100)
    @Column(length=100)
    @NotBlank
    private String nombre_proyecto;
    
    @Size(max=255)
    @Column(length=255)
    private String url;
    
    @Size(max=255)
    @Column(length=255)
    private String lenguaje;
    
    @Size(max=255)
    @Column(length=255)
    private String descripcion;
    
    @Size(max=255)
    @Column(length=255)
    private String img;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usr", referencedColumnName = "idUsr", nullable = false)
    @JsonIgnore
    private Persona persona;

    public Proyecto() {
    }

    public Proyecto(Long id_proyecto, String nombre_proyecto, String url, String lenguaje, String descripcion, String img) {
        this.id_proyecto = id_proyecto;
        this.nombre_proyecto = nombre_proyecto;
        this.url = url;
        this.lenguaje = lenguaje;
        this.descripcion = descripcion;
        this.img = img;
        
    }

    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
    
}
