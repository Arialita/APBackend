package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Persona;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myportfolio.BackendPortfolio.service.IPersonaService;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {
    @Autowired
    public IPersonaService usrServ;
    
    @Autowired
    public IErrorService errorServ; 
    
 /**   @GetMapping("/ver/{id_usr}")
    public ResponseEntity<?> verPersona(@PathVariable Long id_usr){
        return usrServ.verPersona(id_usr);
    }**/
    
    @GetMapping("/ver/{idUsr}")
    public ResponseEntity<?> verPersonaDto(@PathVariable Long idUsr){
        return usrServ.verPersonaDto(idUsr);
    }
    
    @PutMapping("/editar/{id_usr}")
    public ResponseEntity<?> editarPersona(@PathVariable Long id_usr, @RequestBody Persona persona){
        if(!errorServ.existeSeccion(id_usr, "usuario")){
            return errorServ.noExiste();
        }
        
         // Campos obligatorios
        if(StringUtils.isBlank(persona.getNombre())){
            return errorServ.campoObligatorio("El nombre");
        }
        
        if(StringUtils.isBlank(persona.getApellido())){
            return errorServ.campoObligatorio("El apellido");
        }
        
         
        // Verificando longitud de carácteres
        if(StringUtils.length(persona.getNombre())> 20) {
            return errorServ.longitudCampo("20", "El nombre");
        }
        
        if(StringUtils.length(persona.getApellido())> 20) {
            return errorServ.longitudCampo("20", "El apellido");
        }
        
        if(StringUtils.length(persona.getOcupacion())> 20) {
            return errorServ.longitudCampo("20", "La ocupación");
        }
        
        if(StringUtils.length(persona.getLocalidad())> 50) {
            return errorServ.longitudCampo("50", "La localidad");
        }
        
        if(StringUtils.length(persona.getProvincia())> 50) {
            return errorServ.longitudCampo("50", "La provincia");
        }
        
        if(StringUtils.length(persona.getAcercaDe())> 255) {
            return errorServ.longitudCampo("255", "La descripción");
        }
        
        persona.setIdUsr(id_usr);
        
        return usrServ.editarPersona(persona, id_usr);
    }
    
    /**@PostMapping("/crear")
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona persona) {
        return usrServ.crearPersona(persona);
    }**/
    
}
