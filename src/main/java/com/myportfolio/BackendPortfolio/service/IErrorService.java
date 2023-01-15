package com.myportfolio.BackendPortfolio.service;

import java.time.ZonedDateTime;
import org.springframework.http.ResponseEntity;

public interface IErrorService {
    public ResponseEntity<?> campoObligatorio(String campo);
    
    public ResponseEntity<?> longitudCampo(String length, String campo);
    
    public boolean existeSeccion(Long id, String seccion);
    
    public ResponseEntity<?> noExiste();
    
    public ZonedDateTime esFechaValida(String fecha);
    
    public ResponseEntity<?> fechaInvalida();

    public ResponseEntity<?> ordenFecha();
}
