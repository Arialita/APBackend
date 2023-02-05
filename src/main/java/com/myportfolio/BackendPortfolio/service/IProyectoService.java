package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Proyecto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IProyectoService {
    public ResponseEntity<List<Proyecto>> verProyectos();
    
    public ResponseEntity<Proyecto> verProyecto(Long id_proy);
    
    public ResponseEntity<?> crearProyecto(Proyecto proy);
    
    public ResponseEntity<?> editarProyecto(Proyecto proy);
    
    public ResponseEntity<?> borrarProyecto(Long id_proy);
    
    public Proyecto buscarProyecto(Long id_proy);
    
}
