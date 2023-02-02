package com.myportfolio.BackendPortfolio.dto;

public class TrabajoDto {
    private Long id_trab;
    
    private String puesto;
    
    private String compania;
    
    private String descripcion;
    
    private String fecha_ini;
    
    private String fecha_fin;


    public TrabajoDto(String puesto, String compania, String descripcion, String fecha_ini, String fecha_fin) {
        this.puesto = puesto;
        this.compania = compania;
        this.descripcion = descripcion;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
    }   
    

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Long getId_trab() {
        return id_trab;
    }

    public void setId_trab(Long id_trab) {
        this.id_trab = id_trab;
    }
    
     
}
