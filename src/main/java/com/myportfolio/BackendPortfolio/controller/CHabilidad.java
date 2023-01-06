package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Habilidad;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.IHabilidadService;
import com.myportfolio.BackendPortfolio.service.IUsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CHabilidad {
    @Autowired
    public IHabilidadService habServ;
    
    @Autowired
    public IUsuarioService usrServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @GetMapping("/ver/habilidad")
    public ResponseEntity<List<Habilidad>> verHabilidad(){
        return habServ.verHabilidad();
    }
    
    @PostMapping("/crear/usuario/{id_usr}/habilidad")
    public ResponseEntity<?> crearHab(@PathVariable Long id_usr, @RequestBody Habilidad hab) {
        if(!errorServ.existeSeccion(id_usr, "usuario")){
            return errorServ.noExiste();
        }
        return seccionValida(hab, id_usr, false);
    }
    
    @PutMapping("/editar/usuario/{id_usr}/habilidad/{id_hab}")
    public ResponseEntity<?> editarHabilidad(@PathVariable Long id_usr, @PathVariable Long id_hab, @RequestBody Habilidad hab) {
        if(!errorServ.existeSeccion(id_usr, "usuario")|| !errorServ.existeSeccion(id_hab, "hab")){
            return errorServ.noExiste();
        }
        hab.setId_hab(id_hab);
        return seccionValida(hab, id_usr, true);
    }
    
    @DeleteMapping("/borrar/habilidad/{id_hab}")
    public ResponseEntity<?> borrarHabilidad (@PathVariable Long id_hab) {
        if(!errorServ.existeSeccion(id_hab, "hab")){
            return errorServ.noExiste();
        }
        return habServ.borrarHabilidad(id_hab);
    }

    private ResponseEntity<?> seccionValida(Habilidad hab, Long id_usr, boolean editando) {
        hab.setUsuario(usrServ.buscarUsuario(id_usr));
        
        if(StringUtils.isBlank(hab.getNombre_hab())) {
            return errorServ.campoObligatorio("La habilidad");
        }
        
        if(StringUtils.isBlank(hab.getNombre_hab())){
            return errorServ.campoObligatorio("El progreso");
        }
        
        if(StringUtils.length(hab.getNombre_hab()) > 100) {
            return errorServ.longitudCampo("100", "La habilidad");
        }
        
        if(StringUtils.length(hab.getNivel()) > 20) {
            return errorServ.longitudCampo("20", "El grado de conocimiento");
        }
        
        if(editando) {
            return habServ.editarHabilidad(hab);
        }
        
        return habServ.crearHabilidad(hab);
    }
}
