package com.myportfolio.BackendPortfolio.repository;

import com.myportfolio.BackendPortfolio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
