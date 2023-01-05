package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Educacion;
import com.myportfolio.BackendPortfolio.model.Usuario;
import com.myportfolio.BackendPortfolio.service.IEducacionService;
import com.myportfolio.BackendPortfolio.service.IErrorService;
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
public class CEducacion {
    @Autowired
    public IEducacionService eduServ;
    
    @Autowired
    public IErrorService errorServ;
    
    @Autowired
    public IUsuarioService usrServ;
    
    @GetMapping("/ver/educacion")
    public ResponseEntity<List<Educacion>> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @PostMapping("/crear/usuario/{id_usr}/educacion")
    public ResponseEntity<?> crearUsuario(@PathVariable Long id_usr, @RequestBody Map<String, String> edu){
        if(!errorServ.existeUsuario(id_usr)){
            return errorServ.noExiste();
        }
        
        return usuarioValido(edu, false, id_usr);
    }
    
    @PutMapping("editar/usuario/{id_usr}/educacion/{id_edu}")
    public ResponseEntity<?> editarEducacion(@PathVariable Long id_usr, @PathVariable Long id_edu, @RequestBody Map<String, String> educacion){
        
        if(!errorServ.existeUsuario(id_usr) || !errorServ.existeEducacion(id_edu)){
            return errorServ.noExiste();
        }
        educacion.put("id_edu",id_edu.toString() );
        return usuarioValido(educacion, true, id_usr);
    }
    
    @DeleteMapping("borrar/educacion/{id_edu}")
    public ResponseEntity<?> borrarUsuario(@PathVariable Long id_edu) {
        if(!errorServ.existeEducacion(id_edu)){
            return errorServ.noExiste();
        }
        return eduServ.borrarEducacion(id_edu);
    }

    // VERIFICO EDUCACION
    public ResponseEntity<?> usuarioValido(Map<String, String> edu, Boolean editando, Long id_usr){
        
        // Instancio mi entidad
        Educacion educacion = new Educacion();
        
        // Busco a qué usuario pertence
        Usuario usr = usrServ.buscarUsuario(id_usr);
        
        // VERIFICO si ambas son fechas válidas
        LocalDate fecha_ini = errorServ.esFechaValida(edu.get("fecha_ini"));
        LocalDate fecha_fin = errorServ.esFechaValida(edu.get("fecha_fin"));
        
        if(fecha_ini == null || fecha_fin == null) {
            return errorServ.fechaInvalida();
        }
        
        // Campos obligatorios
        if(StringUtils.isBlank(edu.get("titulo"))){
            return errorServ.campoObligatorio("El título");
        }
        
        if(StringUtils.isBlank(edu.get("instituto"))){
            return errorServ.campoObligatorio("La institución educativa");
        }
        
        // Verificando longitud de carácteres
        if(StringUtils.length(edu.get("titulo")) > 100) {
            return errorServ.longitudCampo("100", "El título");
        }
        
        if(StringUtils.length(edu.get("instituto"))> 100) {
            return errorServ.longitudCampo("100", "La institución educativa");
        }
        
        // Verifico que la fecha final venga después que la inicial
        if(fecha_ini.compareTo(fecha_fin) >= 0){
            return errorServ.ordenFecha();
        }
        
        // Setteo mi educacion
        educacion.setTitulo(edu.get("titulo"));
        educacion.setInstituto(edu.get("instituto"));
        educacion.setFecha_ini(fecha_ini);
        educacion.setFecha_fin(fecha_fin);
        educacion.setUsuario(usr);
        
        if(editando) {
            educacion.setId_edu(Long.valueOf(edu.get("id_edu")));
            return eduServ.editarEducacion(educacion);
        }
        return eduServ.crearEducacion(educacion);
    }
    
}
