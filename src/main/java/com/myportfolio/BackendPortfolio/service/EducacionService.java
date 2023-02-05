package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Educacion;
import com.myportfolio.BackendPortfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public ResponseEntity<List<Educacion>> verEducaciones() {
        return new ResponseEntity(eduRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearEducacion(Educacion edu) {
        return new ResponseEntity(eduRepo.save(edu), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarEducacion(Educacion edu) {
        Educacion temp= eduRepo.save(edu);
        return new ResponseEntity(temp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarEducacion(Long id_edu) {
        eduRepo.deleteById(id_edu);
        return new ResponseEntity(eduRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public Educacion buscarEducacion(Long id_edu) {
        return eduRepo.findById(id_edu).orElse(null);
    }

    @Override
    public ResponseEntity<Educacion> verEducacion(Long id_edu) {
        return new ResponseEntity(eduRepo.findById(id_edu).orElse(null), HttpStatus.OK);
    }
    
}
