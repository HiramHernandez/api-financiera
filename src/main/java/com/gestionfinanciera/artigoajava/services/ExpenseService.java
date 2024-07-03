package com.gestionfinanciera.artigoajava.services;

import com.gestionfinanciera.artigoajava.entities.Expense;
import com.gestionfinanciera.artigoajava.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAll(){
        return expenseRepository.findAll();
    }

    public Expense getById(Long id){
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.get();
    }

}
