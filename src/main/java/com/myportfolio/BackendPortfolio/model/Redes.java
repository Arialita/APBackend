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
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Redes {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id_redes;
   
    @Size(max=255)
    @Column(length=255)
    private String instagram;
    
    @Size(min=2, max=255)
    @Column(length=255)
    private String linkedIn;
    
    @Size(min=2, max=255)
    @Column(length=255)
    private String github;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usr", referencedColumnName = "idUsr", nullable = false)
    @JsonIgnore
    private Persona persona;

    public Redes() {
    }

    public Redes(String instagram, String linkedIn, String github) {
        this.instagram = instagram;
        this.linkedIn = linkedIn;
        this.github = github;
    }
}
