package com.myportfolio.BackendPortfolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


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
    
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Educacion> educacion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Trabajo> trabajo;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Habilidad> habilidad;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Proyecto> proyecto;*/
    

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

    public Long getId_usr() {
        return id_usr;
    }

    public void setId_usr(Long id_usr) {
        this.id_usr = id_usr;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getAcerca_de() {
        return acerca_de;
    }

    public void setAcerca_de(String acerca_de) {
        this.acerca_de = acerca_de;
    }
    
    
    
}
