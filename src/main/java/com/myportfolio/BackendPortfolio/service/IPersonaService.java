package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.dto.PersonaDto;
import com.myportfolio.BackendPortfolio.model.Persona;
import org.springframework.http.ResponseEntity;

public interface IPersonaService {
    
    public ResponseEntity<Persona> verPersona(Long id_usr);
    
    public ResponseEntity<Persona> editarPersona(Persona persona, Long id_usr);
    
    public Persona buscarPersona(Long id_usr);

    public ResponseEntity<Persona> crearPersona(Persona persona);
    
    public ResponseEntity<PersonaDto> verPersonaDto(Long idUsr);
}
