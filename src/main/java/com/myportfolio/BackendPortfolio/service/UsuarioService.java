package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    public UsuarioRepository usrRepo;
    
    @Override
    public ResponseEntity<List<Usuario>> verUsuario() {
        return new ResponseEntity<>(usrRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> crearUsuario(Usuario usr) {
        usrRepo.save(usr);
        return new ResponseEntity("Usuario creado con éxito", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> editarUsuario(Usuario usr) {
        usrRepo.save(usr);
        return new ResponseEntity("Usuario editado con éxito", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> borrarUsuario(Long id_usr) {
        usrRepo.deleteById(id_usr);
        return new ResponseEntity("Usuario borrado con éxito", HttpStatus.OK);
    }

    @Override
    public Usuario buscarUsuario(Long id_usr) {
        return usrRepo.findById(id_usr).orElse(null);
    }
    
}
