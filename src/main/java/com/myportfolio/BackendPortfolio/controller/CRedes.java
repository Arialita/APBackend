package com.myportfolio.BackendPortfolio.controller;

import com.myportfolio.BackendPortfolio.model.Redes;
import com.myportfolio.BackendPortfolio.service.ErrorService;
import com.myportfolio.BackendPortfolio.service.IPersonaService;
import com.myportfolio.BackendPortfolio.service.IRedesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redes")
@CrossOrigin(origins = "http://localhost:4200")
public class CRedes {
    
    @Autowired
    public IRedesService redesServ;
    
    @Autowired
    public ErrorService errorServ;
    
    @Autowired
    public IPersonaService persoServ;
    
    @GetMapping("/ver/{id_redes}")
    public ResponseEntity<Redes> verRedesDetalle(@PathVariable Long id_redes){
        return redesServ.verRedesDetalle(id_redes);
    }
    
    @PutMapping("/editar/{id_redes}")
    public ResponseEntity<?> editarRedes(@PathVariable Long id_redes, @RequestBody Redes redes){
        if(!errorServ.existeSeccion(id_redes, "redes")){
            return errorServ.noExiste();
        }
        return validateRedes(redes, id_redes);
    }

    private ResponseEntity<?> validateRedes(Redes temp, Long id_redes) {
        Redes redes = redesServ.buscarRedes(id_redes);
        
        // Verificando longitud de carácteres
        if((StringUtils.length(temp.getInstagram()) > 255) || (StringUtils.length(temp.getLinkedIn()) > 255) || (StringUtils.length(temp.getGithub()) > 255)) {
            return errorServ.longitudCampo("255", "La url");
        }
        
        redes.setInstagram(temp.getInstagram());
        redes.setLinkedIn(temp.getLinkedIn());
        redes.setGithub(temp.getGithub());
        
        return redesServ.editarRedes(redes);
    }
}
