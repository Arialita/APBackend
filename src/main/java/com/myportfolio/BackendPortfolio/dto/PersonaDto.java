package com.myportfolio.BackendPortfolio.dto;

public class PersonaDto {
    private String nombre;
    private String apellido;
    private String ocupacion;
    private String localidad;
    private String provincia;
    private String acercaDe;
    private String avatar;
    private String background;

    public PersonaDto(String nombre, String apellido, String ocupacion, String localidad, String provincia, String acercaDe, String avatar, String background) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ocupacion = ocupacion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.acercaDe = acercaDe;
        this.avatar = avatar;
        this.background = background;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
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

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
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
}
