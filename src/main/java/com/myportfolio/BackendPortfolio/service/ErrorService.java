package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.repository.EducacionRepository;
import com.myportfolio.BackendPortfolio.repository.HabilidadRepository;
import com.myportfolio.BackendPortfolio.repository.ProyectoRepository;
import com.myportfolio.BackendPortfolio.repository.TrabajoRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.myportfolio.BackendPortfolio.repository.PersonaRepository;

@Service
public class ErrorService implements IErrorService{
    @Autowired
    public PersonaRepository usrRepo;
    
    @Autowired
    public EducacionRepository eduRepo;
    
    @Autowired
    public TrabajoRepository trabRepo;
    
    @Autowired
    public HabilidadRepository habRepo;
    
    @Autowired
    public ProyectoRepository proyRepo;

    @Override
    public ResponseEntity<?> campoObligatorio(String campo) {
        return new ResponseEntity(campo + " es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> longitudCampo(String length, String campo) {
        return new ResponseEntity(campo + " debe tener menos de " + length  + " carácteres", HttpStatus.BAD_REQUEST);
    }

     @Override
    public boolean existeSeccion(Long id, String seccion) {
        switch (seccion) {
            case "usuario" -> {
                return usrRepo.existsById(id);
            }
            case "edu" -> {
                return eduRepo.existsById(id);
            }
            case "trab" -> {
                return trabRepo.existsById(id);
            }
            case "hab" -> {
                return habRepo.existsById(id);
            }
            case "proy" -> {
                return proyRepo.existsById(id);
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    public ResponseEntity<?> noExiste() {
        return new ResponseEntity("La sección no existe", HttpStatus.BAD_REQUEST);
    }

    
    @Override
    public ZonedDateTime esFechaValida(String fecha) {
        String DATE_FORMAT = "uuuu-MM-dd HH:mm:ss";
        
        
        ZonedDateTime ld;
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(fecha, DateTimeFormatter.ofPattern(DATE_FORMAT).withResolverStyle(ResolverStyle.STRICT));
            ZonedDateTime systemZoneDateTime = localDateTime.atZone(ZoneId.systemDefault());
            ZonedDateTime date = systemZoneDateTime.withZoneSameInstant(ZoneId.of("UTC"));
            ld = date;
        }
        catch(DateTimeParseException e){
            return null;
        }
        return ld;
    }
    
    @Override
    public ResponseEntity<?> fechaInvalida() {
        return new ResponseEntity("La fecha no existe", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> ordenFecha() {
        return new ResponseEntity("La fecha final viene después de la inicial", HttpStatus.BAD_REQUEST);
    }    
}
