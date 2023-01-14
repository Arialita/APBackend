package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Usuario;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {
    
    public ResponseEntity<Usuario> verUsuario(Long id_usr);
    
    public ResponseEntity<Usuario> editarUsuario(Usuario usr);
    
    public Usuario buscarUsuario(Long id_usr);
}
