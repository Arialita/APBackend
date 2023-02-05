package com.myportfolio.BackendPortfolio.security.repository;

import com.myportfolio.BackendPortfolio.security.entity.Rol;
import com.myportfolio.BackendPortfolio.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
