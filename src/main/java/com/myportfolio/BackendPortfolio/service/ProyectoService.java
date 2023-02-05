package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Proyecto;
import com.myportfolio.BackendPortfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService {
    
    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public ResponseEntity<List<Proyecto>> verProyectos() {
        return new ResponseEntity(proyRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearProyecto(Proyecto proy) {
        return new ResponseEntity(proyRepo.save(proy), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarProyecto(Proyecto proy) {
        return new ResponseEntity(proyRepo.save(proy), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarProyecto(Long id_proy) {
        proyRepo.deleteById(id_proy);
        return new ResponseEntity(proyRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public Proyecto buscarProyecto(Long id_proy) {
        return proyRepo.findById(id_proy).orElse(null);
    }

    @Override
    public ResponseEntity<Proyecto> verProyecto(Long id_proy) {
        return new ResponseEntity(proyRepo.findById(id_proy).orElse(null), HttpStatus.OK);
    }
}
