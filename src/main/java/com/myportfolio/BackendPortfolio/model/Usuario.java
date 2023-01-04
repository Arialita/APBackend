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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_usr;
    
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
    private String acerca_de;
    
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
   // private List<?> educacion;
    
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    //private List<?> trabajo;

    public Usuario() {
    }
    
    public Usuario(Long id_usr, String nombre, String apellido, String ocupacion, String localidad, String provincia, String acerca_de) {
        this.id_usr = id_usr;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.acerca_de = acerca_de;
    }
    
    
}
