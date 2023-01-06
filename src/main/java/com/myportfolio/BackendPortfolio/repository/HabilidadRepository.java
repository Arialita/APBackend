package com.myportfolio.BackendPortfolio.repository;

import com.myportfolio.BackendPortfolio.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Long>{
    
}
