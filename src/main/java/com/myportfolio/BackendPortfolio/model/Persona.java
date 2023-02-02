package com.myportfolio.BackendPortfolio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUsr;
    
    @Size(min=2, max=20)
    @Column(length=20)
    @NotBlank
    private String nombre;
    
    @Size(min=2, max=20)
    @Column(length=20)
    @NotBlank
    private String apellido;
    
    @Size(min=2, max=20)
    @Column(length=20)
    private String ocupacion;
    
    @Size(min=2, max=50)
    @Column(length=50)
    private String localidad;
    
    @Size(min=2, max=50)
    @Column(length=50)
    private String provincia;
    
    @Size(min=2, max=255)
    @Column(length=255)
    private String acercaDe;
    
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Educacion> educacion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Trabajo> trabajo;*/
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Habilidad> habilidad;
    
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Proyecto> proyecto;*/
    

    public Persona() {
    }
    
    public Persona(Long idUsr, String nombre, String apellido, String ocupacion, String localidad, String provincia, String acercaDe) {
        this.idUsr = idUsr;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.acercaDe = acercaDe;
    }  
    
}
