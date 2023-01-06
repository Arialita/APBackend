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
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_hab;
    
    @Size(max = 100)
    @Column(length=100)
    @NotBlank
    private String nombre_hab;
    
    @Size(max=20)
    @Column(length=20)
    @NotBlank
    private String nivel;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_usr", referencedColumnName = "id_usr", nullable = false)
    @JsonIgnore
    private Usuario usuario;

    public Habilidad() {
    }

    public Habilidad(Long id_hab, String nombre_hab, String nivel) {
        this.id_hab = id_hab;
        this.nombre_hab = nombre_hab;
        this.nivel = nivel;
    }

    
}
