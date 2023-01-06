package com.myportfolio.BackendPortfolio.service;


import com.myportfolio.BackendPortfolio.model.Habilidad;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IHabilidadService {
    public ResponseEntity<List<Habilidad>> verHabilidad();
    
    public ResponseEntity<?> crearHabilidad(Habilidad hab);
    
    public ResponseEntity<?> editarHabilidad(Habilidad hab);
    
    public ResponseEntity<?> borrarHabilidad(Long id_hab);
    
    public Habilidad buscarHabilidad(Long id_hab);
}
