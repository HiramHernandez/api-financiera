package com.gestionfinanciera.artigoajava.repositories;

import com.gestionfinanciera.artigoajava.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
