package com.gestionfinanciera.artigoajava.repositories;

import com.gestionfinanciera.artigoajava.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
