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
    public ResponseEntity<List<Proyecto>> verProyecto() {
        return new ResponseEntity(proyRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearProyecto(Proyecto proy) {
        proyRepo.save(proy);
        return new ResponseEntity("Campo creado con éxito", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarProyecto(Proyecto proy) {
        proyRepo.save(proy);
        return new ResponseEntity("Campo editado con éxito", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarProyecto(Long id_proy) {
        proyRepo.deleteById(id_proy);
        return new ResponseEntity("Campo borrado con éxito", HttpStatus.OK);
    }

    @Override
    public Proyecto buscarProyecto(Long id_proy) {
        return proyRepo.findById(id_proy).orElse(null);
    }
}
