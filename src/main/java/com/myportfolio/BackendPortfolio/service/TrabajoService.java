package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Trabajo;
import com.myportfolio.BackendPortfolio.repository.TrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrabajoService implements ITrabajoService {
    
    @Autowired
    public TrabajoRepository trabRepo;
            
    @Override
    public ResponseEntity<List<Trabajo>> verTrabajo() {
        return new ResponseEntity(trabRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearTrabajo(Trabajo trabajo) {
        trabRepo.save(trabajo);
        return new ResponseEntity("Campo creado exitosamente.", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarTrabajo(Trabajo trabajo) {
        trabRepo.save(trabajo);
        return new ResponseEntity("Campo editado exitosamente.",null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarTrabajo(Long id_trab) {
        trabRepo.deleteById(id_trab);
        return new ResponseEntity("Campo borrado exitosamente.", HttpStatus.OK);
    }

    @Override
    public Trabajo buscarTrabajo(Long id_trab) {
        return trabRepo.findById(id_trab).orElse(null);
    }
    
}
