package com.myportfolio.BackendPortfolio.repository;

import com.myportfolio.BackendPortfolio.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Long>{
    
}
