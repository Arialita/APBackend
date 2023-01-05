package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ErrorService implements IErrorService{
    @Autowired
    public UsuarioRepository usrRepo;

    @Override
    public ResponseEntity<?> campoObligatorio(String campo) {
        return new ResponseEntity(campo + " es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> longitudCampo(String length, String campo) {
        return new ResponseEntity(campo + " debe tener menos de " + length  + " carácteres", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Boolean existeUsuario(Long id_usr) {
        return usrRepo.existsById(id_usr);
    }

    @Override
    public ResponseEntity<?> noExiste() {
        return new ResponseEntity("Usuario inexistente", HttpStatus.BAD_REQUEST);
    }
    
}
