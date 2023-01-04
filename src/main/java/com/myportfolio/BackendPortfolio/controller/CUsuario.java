package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CUsuario {
    @Autowired
    public IUsuarioService usrServ;
    
    @GetMapping("/ver/usuarios")
    public ResponseEntity<List<Usuario>> verUsuario(){
        return usrServ.verUsuario();
    }
    
    @PostMapping("/crear/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return usrServ.crearUsuario(usuario);
    }
    
    @PutMapping("editar/usuario/{id_usr}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id_usr, @RequestBody Usuario usuario){
        usuario.setId_usr(id_usr);
        return usrServ.editarUsuario(usuario);
    }
    
    @DeleteMapping("borrar/usuario/{id_usr}")
    public ResponseEntity<?> borrarUsuario(@PathVariable Long id_usr) {
        return usrServ.borrarUsuario(id_usr);
    }
}
