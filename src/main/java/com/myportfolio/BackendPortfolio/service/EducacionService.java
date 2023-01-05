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
    public ResponseEntity<List<Educacion>> verEducacion() {
        return new ResponseEntity(eduRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearEducacion(Educacion edu) {
        eduRepo.save(edu);
        return new ResponseEntity("Campo creado exitosamente", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarEducacion(Educacion edu) {
        eduRepo.save(edu);
        return new ResponseEntity("Campo editado exitosamente", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarEducacion(Long id_edu) {
        eduRepo.deleteById(id_edu);
        return new ResponseEntity("Campo borrado exitosamente", HttpStatus.OK);
    }

    @Override
    public Educacion buscarEducacion(Long id_edu) {
        return eduRepo.findById(id_edu).orElse(null);
    }
    
}
