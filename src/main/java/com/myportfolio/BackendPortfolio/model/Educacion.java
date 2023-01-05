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
import java.time.LocalDate;
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
    
    @NotBlank
    private LocalDate fecha_ini;
    
    @NotBlank
    private LocalDate fecha_fin;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_usr", referencedColumnName="id_usr", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Educacion() {
    }

    public Educacion(Long id_edu, String titulo, String instituto, LocalDate fecha_ini, LocalDate fecha_fin) {
        this.id_edu = id_edu;
        this.titulo = titulo;
        this.instituto = instituto;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }
}
