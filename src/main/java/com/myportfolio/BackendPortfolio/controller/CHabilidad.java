package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Habilidad;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.IHabilidadService;
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
@RequestMapping("/habilidad")
@CrossOrigin(origins = "https://frontendportfolio-c9069.web.app")
public class CHabilidad {
    @Autowired
    public IHabilidadService habServ;
    
    @Autowired
    public IPersonaService usrServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @GetMapping("/ver")
    public ResponseEntity<List<Habilidad>> verHabilidades(){
        return habServ.verHabilidades();
    }
    
    @GetMapping("/ver/{id_hab}")
    public ResponseEntity<Habilidad> verHabilidad(@PathVariable Long id_hab){
        return habServ.verHabilidad(id_hab);
    }
    
    @PostMapping("/crear/{id_usr}")
    public ResponseEntity<?> crearHab(@PathVariable Long id_usr, @RequestBody Habilidad hab) {
        if(!errorServ.existeSeccion(id_usr, "usuario")){
            return errorServ.noExiste();
        }
        return seccionValida(hab, id_usr, false, null);
    }
    
    @PutMapping("/editar/{id_usr}/{id_hab}")
    public ResponseEntity<?> editarHabilidad(@PathVariable Long id_usr, @PathVariable Long id_hab, @RequestBody Habilidad hab) {
        if(!errorServ.existeSeccion(id_usr, "usuario")|| !errorServ.existeSeccion(id_hab, "hab")){
            return errorServ.noExiste();
        }
        return seccionValida(hab, id_usr, true, id_hab);
    }
    
    @DeleteMapping("/borrar/{id_hab}")
    public ResponseEntity<?> borrarHabilidad (@PathVariable Long id_hab) {
        if(!errorServ.existeSeccion(id_hab, "hab")){
            return errorServ.noExiste();
        }
        return habServ.borrarHabilidad(id_hab);
    }

    private ResponseEntity<?> seccionValida(Habilidad hab, Long id_usr, boolean editando, Long id_hab) {
        Habilidad temp = new Habilidad();
        if(editando){
            temp = habServ.buscarHabilidad(id_hab);
        }
        if(StringUtils.isBlank(hab.getNombre_hab())) {
            return errorServ.campoObligatorio("La habilidad");
        }
        
        if(StringUtils.isBlank(hab.getNombre_hab())){
            return errorServ.campoObligatorio("El progreso");
        }
        
        if(StringUtils.length(hab.getNombre_hab()) > 100) {
            return errorServ.longitudCampo("100", "La habilidad");
        }
        
        if(StringUtils.length(hab.getNivel_nombre()) > 100) {
            return errorServ.longitudCampo("100", "El grado de conocimiento");
        }
        
        if(!editando) {
            hab.setPersona(usrServ.buscarPersona(id_usr));
            return habServ.crearHabilidad(hab);
        }
        
        temp.setNivel(hab.getNivel());
        temp.setNivel_nombre(hab.getNivel_nombre());
        temp.setNombre_hab(hab.getNombre_hab());
        
        return habServ.editarHabilidad(temp);
        
    }
}
