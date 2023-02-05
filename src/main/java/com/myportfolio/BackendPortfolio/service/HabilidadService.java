package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Habilidad;
import com.myportfolio.BackendPortfolio.repository.HabilidadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    public HabilidadRepository habRepo;
    
    @Override
    public ResponseEntity<List<Habilidad>> verHabilidades() {
        return new ResponseEntity(habRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearHabilidad(Habilidad hab) {
        habRepo.save(hab);
        return new ResponseEntity(  habRepo.save(hab), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarHabilidad(Habilidad hab) {
        return new ResponseEntity(  habRepo.save(hab), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarHabilidad(Long id_hab) {
        habRepo.deleteById(id_hab);
        return new ResponseEntity(habRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public Habilidad buscarHabilidad(Long id_hab) {
        return habRepo.findById(id_hab).orElse(null);
    }

    @Override
    public ResponseEntity<Habilidad> verHabilidad(Long id_hab) {
        return new ResponseEntity(habRepo.findById(id_hab).orElse(null),HttpStatus.OK);
    }
    
}
