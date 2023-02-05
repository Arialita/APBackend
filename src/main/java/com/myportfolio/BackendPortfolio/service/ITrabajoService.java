package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Trabajo;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ITrabajoService {
    
    public ResponseEntity<List<Trabajo>> verTrabajos();
    
    public ResponseEntity<Trabajo> verTrabajo(Long id_trab);
    
    public ResponseEntity<Trabajo> crearTrabajo(Trabajo trabajo);
    
    public ResponseEntity<Trabajo> editarTrabajo(Trabajo trabajo);
    
    public ResponseEntity<?> borrarTrabajo(Long id_trab);
    
    public Trabajo buscarTrabajo(Long id_trab);
}
