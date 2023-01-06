package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Trabajo;
import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.service.IErrorService;
import com.myportfolio.BackendPortfolio.service.ITrabajoService;
import com.myportfolio.BackendPortfolio.service.IUsuarioService;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
public class CTrabajo {
    @Autowired
    public ITrabajoService trabServ;
    
    @Autowired
    public IUsuarioService usrServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @GetMapping("/ver/trabajos")
    public ResponseEntity<List<Trabajo>> verTrabajo(){
        return trabServ.verTrabajo();
    }
    
    @PostMapping("/crear/usuario/{id_usr}/trabajo")
    public ResponseEntity<?> crearTrabajo(@PathVariable Long id_usr, @RequestBody Map<String, String> trabajo) {
        if(!errorServ.existeSeccion(id_usr, "usuario")) {
            return errorServ.noExiste();
        }
        return usuarioValido(trabajo, id_usr, false);
    }
    
    @PutMapping("/editar/usuario/{id_usr}/trabajo/{id_trab}")
    public ResponseEntity<?> editarTrabajo(@PathVariable Long id_usr, @PathVariable Long id_trab, @RequestBody Map<String, String> trabajo) {
        if(!errorServ.existeSeccion(id_usr, "usuario") || !errorServ.existeSeccion(id_trab, "trab")) {
            return errorServ.noExiste();
        }
        trabajo.put("id_trab", id_trab.toString());
        return usuarioValido(trabajo, id_usr, true);
    }
    
    @DeleteMapping("borrar/trabajo/{id_trab}")
    public ResponseEntity<?> borrarTrabajo(@PathVariable Long id_trab) {
        if(!errorServ.existeSeccion(id_trab, "trab")){
            return errorServ.noExiste();
        }
        return trabServ.borrarTrabajo(id_trab);
    }
    
    // Valido los datos ingresados
    private ResponseEntity<?> usuarioValido(Map<String, String> trab, Long id_usr, boolean editando) {
        // Creo un trabajo vacío
        Trabajo trabajo = new Trabajo();
        
        // Busco el usuario
        Usuario usr = usrServ.buscarUsuario(id_usr);
        
        // VERIFICO si ambas son fechas válidas
        LocalDate fecha_ini = errorServ.esFechaValida(trab.get("fecha_ini"));
        LocalDate fecha_fin = errorServ.esFechaValida(trab.get("fecha_fin"));
        
        if(fecha_ini == null || fecha_fin == null) {
            return errorServ.fechaInvalida();
        }
        
        // Campos obligatorios
        if(StringUtils.isBlank(trab.get("puesto"))){
            return errorServ.campoObligatorio("El puesto");
        }
        
        if(StringUtils.isBlank(trab.get("compania"))){
            return errorServ.campoObligatorio("La compania");
        }
        
        // Verificando longitud de carácteres
        if(StringUtils.length(trab.get("puesto")) > 100) {
            return errorServ.longitudCampo("100", "El puesto");
        }
        
        if(StringUtils.length(trab.get("compania"))> 100) {
            return errorServ.longitudCampo("100", "La compania");
        }
        
        // Verifico que la fecha final venga después que la inicial
        if(fecha_ini.compareTo(fecha_fin) >= 0){
            return errorServ.ordenFecha();
        }
        
        // Setteo trabajo
        trabajo.setPuesto(trab.get("puesto"));
        trabajo.setCompania(trab.get("compania"));
        trabajo.setFecha_ini(fecha_ini);
        trabajo.setFecha_fin(fecha_fin);
        trabajo.setUsuario(usr);
        
        if(editando){
            trabajo.setId_trab(Long.valueOf(trab.get("id_trab")));
            return trabServ.editarTrabajo(trabajo);
        }
        return trabServ.crearTrabajo(trabajo);
    }
}
