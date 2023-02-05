package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.dto.PersonaDto;
import com.myportfolio.BackendPortfolio.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.myportfolio.BackendPortfolio.repository.PersonaRepository;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    public PersonaRepository usrRepo;
    
    @Override
    public ResponseEntity<Persona> verPersona(Long id_usr) {
        return new ResponseEntity(usrRepo.findById(id_usr), HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Persona> editarPersona(Persona persona, Long id_usr) {
        usrRepo.save(persona);
        return new ResponseEntity(usrRepo.findById(id_usr).orElse(null), HttpStatus.OK);
    }
    
    @Override
    public Persona buscarPersona(Long id_usr) {
        return usrRepo.findById(id_usr).orElse(null);
    }
    
    @Override
    public ResponseEntity<Persona> crearPersona(Persona persona) {
        return new ResponseEntity(usrRepo.save(persona), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PersonaDto> verPersonaDto(Long idUsr) {
        return new ResponseEntity(usrRepo.findPersonaDtoByIdUsr(idUsr), HttpStatus.OK);
    }
}
