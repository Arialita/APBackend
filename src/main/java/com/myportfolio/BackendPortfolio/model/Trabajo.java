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
public class Trabajo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_trab;
    
    @Size(min=2, max=100)
    @Column(length=100)
    @NotBlank
    private String puesto;
    
    @Size(min=2, max=100)
    @Column(length=100)
    @NotBlank
    private String compania;
    
    @Size(max=255)
    @Column(length=255)
    private String descripcion;
    
    private ZonedDateTime fecha_ini;
    
    private ZonedDateTime fecha_fin;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_usr", referencedColumnName="idUsr", nullable = false)
    @JsonIgnore
    private Persona persona;

    public Trabajo() {
    }

    public Trabajo(Long id_trab, String puesto, String compania, ZonedDateTime fecha_ini, ZonedDateTime fecha_fin, String descripcion) {
        this.id_trab = id_trab;
        this.puesto = puesto;
        this.compania = compania;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
    }
}
