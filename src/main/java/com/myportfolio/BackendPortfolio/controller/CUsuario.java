package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.IUsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
    
    @Autowired
    public IErrorService errorServ; 
    
    @GetMapping("/ver/usuarios")
    public ResponseEntity<List<Usuario>> verUsuario(){
        return usrServ.verUsuario();
    }
    
    @PostMapping("/crear/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usr){
        return usuarioValido(usr, false);
    }
    
    @PutMapping("editar/usuario/{id_usr}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id_usr, @RequestBody Usuario usuario){
        if(!errorServ.existeUsuario(id_usr)){
            return errorServ.noExiste();
        }
        else {
            usuario.setId_usr(id_usr);
        }
        return usuarioValido(usuario, true);
    }
    
    @DeleteMapping("borrar/usuario/{id_usr}")
    public ResponseEntity<?> borrarUsuario(@PathVariable Long id_usr) {
        if(!errorServ.existeUsuario(id_usr)){
            return errorServ.noExiste();
        }
        return usrServ.borrarUsuario(id_usr);
    }
    
    
    // VERIFICO USUARIO
    public ResponseEntity<?> usuarioValido(Usuario usr, Boolean editando){
         // Campos obligatorios
        if(StringUtils.isBlank(usr.getNombre())){
            return errorServ.campoObligatorio("El nombre");
        }
        
        if(StringUtils.isBlank(usr.getApellido())){
            return errorServ.campoObligatorio("El apellido");
        }
        
         
        // Verificando longitud de carácteres
        if(StringUtils.length(usr.getNombre())> 20) {
            return errorServ.longitudCampo("20", "El nombre");
        }
        
        if(StringUtils.length(usr.getApellido())> 20) {
            return errorServ.longitudCampo("20", "El apellido");
        }
        
        if(StringUtils.length(usr.getOcupacion())> 20) {
            return errorServ.longitudCampo("20", "La ocupación");
        }
        
        if(StringUtils.length(usr.getLocalidad())> 50) {
            return errorServ.longitudCampo("50", "La localidad");
        }
        
        if(StringUtils.length(usr.getProvincia())> 50) {
            return errorServ.longitudCampo("50", "La provincia");
        }
        
        if(StringUtils.length(usr.getAcerca_de())> 255) {
            return errorServ.longitudCampo("255", "La descripción");
        }
        
        if(editando) {
            return usrServ.editarUsuario(usr);
        }
        return usrServ.crearUsuario(usr);
    }
    
}
