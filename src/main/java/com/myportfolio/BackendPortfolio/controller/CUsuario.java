package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.IUsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CUsuario {
    @Autowired
    public IUsuarioService usrServ;
    
    @Autowired
    public IErrorService errorServ; 
    
    @GetMapping("/ver/usuario/{id_usr}")
    public ResponseEntity<?> verUsuario(@PathVariable Long id_usr){
        return usrServ.verUsuario(id_usr);
    }
    
    @PutMapping("editar/usuario/{id_usr}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id_usr, @RequestBody Usuario usuario){
        if(!errorServ.existeSeccion(id_usr, "usuario")){
            return errorServ.noExiste();
        }
        
         // Campos obligatorios
        if(StringUtils.isBlank(usuario.getNombre())){
            return errorServ.campoObligatorio("El nombre");
        }
        
        if(StringUtils.isBlank(usuario.getApellido())){
            return errorServ.campoObligatorio("El apellido");
        }
        
         
        // Verificando longitud de carácteres
        if(StringUtils.length(usuario.getNombre())> 20) {
            return errorServ.longitudCampo("20", "El nombre");
        }
        
        if(StringUtils.length(usuario.getApellido())> 20) {
            return errorServ.longitudCampo("20", "El apellido");
        }
        
        if(StringUtils.length(usuario.getOcupacion())> 20) {
            return errorServ.longitudCampo("20", "La ocupación");
        }
        
        if(StringUtils.length(usuario.getLocalidad())> 50) {
            return errorServ.longitudCampo("50", "La localidad");
        }
        
        if(StringUtils.length(usuario.getProvincia())> 50) {
            return errorServ.longitudCampo("50", "La provincia");
        }
        
        if(StringUtils.length(usuario.getAcerca_de())> 255) {
            return errorServ.longitudCampo("255", "La descripción");
        }
        
        usuario.setId_usr(id_usr);
        
        return usrServ.editarUsuario(usuario);
    }
    
}
