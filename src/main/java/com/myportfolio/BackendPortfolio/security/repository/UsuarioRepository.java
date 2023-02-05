package com.myportfolio.BackendPortfolio.security.repository;

import com.myportfolio.BackendPortfolio.model.Persona;
import com.myportfolio.BackendPortfolio.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    
    boolean existsByEmail(String email);
}
