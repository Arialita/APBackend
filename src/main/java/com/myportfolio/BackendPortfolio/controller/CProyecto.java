package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Proyecto;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.IProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myportfolio.BackendPortfolio.service.IPersonaService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "https://frontendportfolio-c9069.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    public IProyectoService proyServ;
    
    @Autowired
    public IPersonaService usrServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @GetMapping("/ver")
    public ResponseEntity<List<Proyecto>> verProyectos(){
        return proyServ.verProyectos();
    }
    
    @GetMapping("/ver/{id_proy}")
    public ResponseEntity<Proyecto> verProyecto(@PathVariable Long id_proy){
        return proyServ.verProyecto(id_proy);
    }
    
    @PostMapping("/crear/{id_usr}")
    public ResponseEntity<?> crearProyecto(@PathVariable Long id_usr, @RequestBody Proyecto proy) {
        if(!errorServ.existeSeccion(id_usr, "usuario")){
            return errorServ.noExiste();
        }
        return seccionValida(proy, id_usr, false, null);
    }
    
    @PutMapping("/editar/{id_usr}/{id_proy}")
    public ResponseEntity<?> editarProyecto(@PathVariable Long id_usr, @PathVariable Long id_proy, @RequestBody Proyecto proy) {
        if(!errorServ.existeSeccion(id_usr, "usuario") || !errorServ.existeSeccion(id_proy, "proy")){
            return errorServ.noExiste();
        }
        return seccionValida(proy, id_usr, true, id_proy);
    }
    
    @DeleteMapping("/borrar/{id_proy}")
    public ResponseEntity<?> borrarProyecto (@PathVariable Long id_proy) {
        return proyServ.borrarProyecto(id_proy);
    }

    private ResponseEntity<?> seccionValida(Proyecto proy, Long id_usr, boolean editando, Long id_proy) {
        Proyecto temp = new Proyecto();
        if(editando){
            temp = proyServ.buscarProyecto(id_proy);
        }
        
        if(StringUtils.isBlank(proy.getNombre_proyecto())) {
            return errorServ.campoObligatorio("El nombre del proyecto");
        }
        
        if(StringUtils.length(proy.getNombre_proyecto())>100){
            return errorServ.longitudCampo("100", "El nombre de proyecto");
        }
        if(StringUtils.length(proy.getUrl())>255){
            return errorServ.longitudCampo("255", "La URL");
        }
        
        if(!editando){
            proy.setPersona(usrServ.buscarPersona(id_usr));
            return proyServ.crearProyecto(proy);
        }
        
        temp.setLenguaje(proy.getLenguaje());
        temp.setNombre_proyecto(proy.getNombre_proyecto());
        temp.setUrl(proy.getUrl());
        
        return proyServ.editarProyecto(temp);
    }
}
