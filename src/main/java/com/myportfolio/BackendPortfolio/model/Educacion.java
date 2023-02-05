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

@Getter @Setter
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
}
