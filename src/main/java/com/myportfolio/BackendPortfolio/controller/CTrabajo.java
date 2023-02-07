package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.dto.TrabajoDto;
import com.myportfolio.BackendPortfolio.model.Trabajo;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.ITrabajoService;
import java.time.ZonedDateTime;
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
@RequestMapping("/trabajo")
@CrossOrigin(origins = "https://frontendportfolio-c9069.web.app")
public class CTrabajo {
    @Autowired
    public ITrabajoService trabServ;
    
    @Autowired
    public IPersonaService persoServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @GetMapping("/ver")
    public ResponseEntity<List<Trabajo>> verTrabajos(){
        return trabServ.verTrabajos();
    }
    
    @GetMapping("/ver/{id_trab}")
    public ResponseEntity<Trabajo> verTrabajo(@PathVariable Long id_trab){
        return trabServ.verTrabajo(id_trab);
    }
    
    @PostMapping("/crear/{id_usr}")
    public ResponseEntity<?> crearTrabajo(@PathVariable Long id_usr, @RequestBody TrabajoDto trabajo) {
        if(!errorServ.existeSeccion(id_usr, "usuario")) {
            return errorServ.noExiste();
        }
        return usuarioValido(trabajo, id_usr, null,false);
    }
    
    @PutMapping("/editar/{id_usr}/{id_trab}")
    public ResponseEntity<?> editarTrabajo(@PathVariable Long id_usr, @PathVariable Long id_trab, @RequestBody TrabajoDto trabajo) {
        if(!errorServ.existeSeccion(id_usr, "usuario") || !errorServ.existeSeccion(id_trab, "trab")) {
            return errorServ.noExiste();
        }
        return usuarioValido(trabajo, id_usr, id_trab, true);
    }
    
    @DeleteMapping("/borrar/{id_trab}")
    public ResponseEntity<?> borrarTrabajo(@PathVariable Long id_trab) {
        if(!errorServ.existeSeccion(id_trab, "trab")){
            return errorServ.noExiste();
        }
        return trabServ.borrarTrabajo(id_trab);
    }
    
    // Valido los datos ingresados
    private ResponseEntity<?> usuarioValido(TrabajoDto trab, Long id_usr, Long id_trab, boolean editando) {
        // Creo un trabajo vacío
        Trabajo trabajo = new Trabajo();
        if(editando){
            trabajo = trabServ.buscarTrabajo(id_trab);
        } else {
            trabajo.setPersona(persoServ.buscarPersona(id_usr));
        }
        
        // VERIFICO si ambas son fechas válida
        ZonedDateTime fecha_ini = errorServ.esFechaValida(trab.getFecha_ini());
        ZonedDateTime fecha_fin = errorServ.esFechaValida(trab.getFecha_fin());
        
        if(fecha_ini == null || fecha_fin == null) {
            return errorServ.fechaInvalida();
        }
        
        // Campos obligatorios
        if(StringUtils.isBlank(trab.getPuesto())){
            return errorServ.campoObligatorio("El puesto");
        }
        
        if(StringUtils.isBlank(trab.getCompania())){
            return errorServ.campoObligatorio("La compania");
        }
        
        // Verificando longitud de carácteres
        if(StringUtils.length(trab.getPuesto()) > 100) {
            return errorServ.longitudCampo("100", "El puesto");
        }
        
        if(StringUtils.length(trab.getCompania())> 100) {
            return errorServ.longitudCampo("100", "La compania");
        }
        
        if(StringUtils.length(trab.getDescripcion())> 255) {
            return errorServ.longitudCampo("255", "La descripción");
        }
        
        if(fecha_ini.compareTo(fecha_fin) >= 0){
            return errorServ.ordenFecha();
        }
        
        
        // Setteo trabajo
        trabajo.setPuesto(trab.getPuesto());
        trabajo.setCompania(trab.getCompania());
        trabajo.setFecha_ini(fecha_ini);
        trabajo.setFecha_fin(fecha_fin);
        trabajo.setDescripcion(trab.getDescripcion());
        
        if(editando){
            return trabServ.editarTrabajo(trabajo);
        }
        return trabServ.crearTrabajo(trabajo);
    }
}
