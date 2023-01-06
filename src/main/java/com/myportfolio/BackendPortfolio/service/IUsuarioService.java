package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.model.Usuario;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface IUsuarioService {
    public ResponseEntity<List<Usuario>> verTodosUsuarios();
    
    public ResponseEntity<Usuario> verUsuario(Long id_usr);
    
    public ResponseEntity<?> crearUsuario(Usuario usr);
    
    public ResponseEntity<?> editarUsuario(Usuario usr);
    
    public ResponseEntity<?> borrarUsuario(Long id_usr);
    
    public Usuario buscarUsuario(Long id_usr);
}
