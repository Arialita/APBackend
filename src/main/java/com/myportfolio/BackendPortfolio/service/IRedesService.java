package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Redes;
import org.springframework.http.ResponseEntity;

public interface IRedesService {
    public ResponseEntity<Redes> verRedesDetalle(Long id_redes);
    
    public ResponseEntity<Redes> editarRedes(Redes redes);
    
    public ResponseEntity<Redes> crearRedes(Redes redes);
    
    public Redes buscarRedes(Long id_redes);
}
