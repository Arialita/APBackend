package com.myportfolio.BackendPortfolio.dto;

public class EducacionDto {
    
    private String titulo;
    
    private String instituto;
    
    private String fecha_ini;
    
    private String fecha_fin;

    public EducacionDto() {
    }
    
    public EducacionDto(String titulo, String instituto, String fecha_ini, String fecha_fin) {
        this.titulo = titulo;
        this.instituto = instituto;
        this.fecha_ini = fecha_ini;
        this.fecha_fin = fecha_fin;
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
    
}
