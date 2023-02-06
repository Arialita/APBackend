package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Redes;
import com.myportfolio.BackendPortfolio.repository.RedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RedesService implements IRedesService{
    @Autowired
    public RedesRepository redesRepo;

    @Override
    public ResponseEntity<Redes> verRedesDetalle(Long id_redes) {
        return new ResponseEntity(redesRepo.findById(id_redes).orElseThrow(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Redes> editarRedes(Redes redes) {
        return new ResponseEntity(redesRepo.save(redes), HttpStatus.OK);
    }

    @Override
    public Redes buscarRedes(Long id_redes) {
        return redesRepo.findById(id_redes).orElseThrow(null);
    }

    @Override
    public ResponseEntity<Redes> crearRedes(Redes redes) {
        return new ResponseEntity(redesRepo.save(redes), HttpStatus.CREATED);
    }
    
}
