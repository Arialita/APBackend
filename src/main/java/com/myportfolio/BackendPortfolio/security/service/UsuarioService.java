package com.myportfolio.BackendPortfolio.security.service;

import com.myportfolio.BackendPortfolio.model.Persona;
import com.myportfolio.BackendPortfolio.repository.PersonaRepository;
import com.myportfolio.BackendPortfolio.security.entity.Usuario;
import com.myportfolio.BackendPortfolio.security.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Optional<Usuario> getByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    
    public boolean existsByIdUsr(Integer idUsr){
        return usuarioRepository.existsById(idUsr);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
