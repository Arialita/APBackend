package com.myportfolio.BackendPortfolio.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IErrorService {
    public ResponseEntity<?> campoObligatorio(String campo);
    
    public ResponseEntity<?> longitudCampo(String length, String campo);
    
    public Boolean existeUsuario(Long id_usr);
    
    public ResponseEntity<?> noExiste();
}
