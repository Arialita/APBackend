package com.myportfolio.BackendPortfolio.security.service;

import com.myportfolio.BackendPortfolio.security.entity.Rol;
import com.myportfolio.BackendPortfolio.security.enums.RolNombre;
import com.myportfolio.BackendPortfolio.security.repository.RolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
