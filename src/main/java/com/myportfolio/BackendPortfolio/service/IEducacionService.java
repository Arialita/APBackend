package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Educacion;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IEducacionService {
    public ResponseEntity<List<Educacion>> verEducaciones();
    
    public ResponseEntity<Educacion> verEducacion(Long id_edu);
    
    public ResponseEntity<?> crearEducacion(Educacion edu);
    
    public ResponseEntity<?> editarEducacion(Educacion edu);
    
    public ResponseEntity<?> borrarEducacion(Long id_edu);
    
    public Educacion buscarEducacion(Long id_edu);
}
