package com.myportfolio.BackendPortfolio.service;

import com.myportfolio.BackendPortfolio.repository.EducacionRepository;
import com.myportfolio.BackendPortfolio.repository.UsuarioRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ErrorService implements IErrorService{
    @Autowired
    public UsuarioRepository usrRepo;
    
    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public ResponseEntity<?> campoObligatorio(String campo) {
        return new ResponseEntity(campo + " es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> longitudCampo(String length, String campo) {
        return new ResponseEntity(campo + " debe tener menos de " + length  + " carácteres", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Boolean existeUsuario(Long id_usr) {
        return usrRepo.existsById(id_usr);
    }
    
    @Override
    public Boolean existeEducacion(Long id_edu) {
        return eduRepo.existsById(id_edu);
    }


    @Override
    public ResponseEntity<?> noExiste() {
        return new ResponseEntity("La sección no existe", HttpStatus.BAD_REQUEST);
    }

    
    @Override
    public LocalDate esFechaValida(String fecha) {
        LocalDate ld;
        DateTimeFormatter f = DateTimeFormatter.ofPattern ( "uuuu-MM-dd" )
                .withResolverStyle ( ResolverStyle.STRICT );
        try {
            LocalDate fecha1 = LocalDate.parse ( fecha , f );
            ld = fecha1;
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
