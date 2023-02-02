package com.myportfolio.BackendPortfolio.repository;

import com.myportfolio.BackendPortfolio.dto.PersonaDto;
import com.myportfolio.BackendPortfolio.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<PersonaDto> findPersonaDtoByIdUsr(Long idUsr);
}
