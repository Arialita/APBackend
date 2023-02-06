package com.myportfolio.BackendPortfolio.repository;

import com.myportfolio.BackendPortfolio.model.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<Redes, Long>{
    
}
