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
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_edu;
    
    @Size(min=2, max=100)
    @Column(length=100)
    @NotBlank
    private String titulo;
    
    @Size(min=2, max=100)
    @Column(length=100)
    @NotBlank
    private String instituto;
    
    private ZonedDateTime fecha_ini;
    
    private ZonedDateTime fecha_fin;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_usr", referencedColumnName="idUsr", nullable = false)
    @JsonIgnore
    private Persona persona;

    public Educacion() {
    }

    public Educacion(Long id_edu, String titulo, String instituto, ZonedDateTime fecha_ini, ZonedDateTime fecha_fin) {
        this.id_edu = id_edu;
        this.titulo = titulo;
        this.instituto = instituto;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }

    public Long getId_edu() {
        return id_edu;
    }

    public void setId_edu(Long id_edu) {
        this.id_edu = id_edu;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public ZonedDateTime getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(ZonedDateTime fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public ZonedDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(ZonedDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
