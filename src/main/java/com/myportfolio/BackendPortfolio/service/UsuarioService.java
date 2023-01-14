package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    public UsuarioRepository usrRepo;
    
    @Override
    public ResponseEntity<Usuario> verUsuario(Long id_usr) {
        return new ResponseEntity(usrRepo.findById(id_usr), HttpStatus.OK);
    }
    
    @Override
    public ResponseEntity<Usuario> editarUsuario(Usuario usr) {
        
        return new ResponseEntity(usrRepo.save(usr), HttpStatus.OK);
    }
    
    @Override
    public Usuario buscarUsuario(Long id_usr) {
        return usrRepo.findById(id_usr).orElse(null);
    }
    
}
