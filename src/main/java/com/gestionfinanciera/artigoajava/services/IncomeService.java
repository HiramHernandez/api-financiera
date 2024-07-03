package com.gestionfinanciera.artigoajava.services;

import com.gestionfinanciera.artigoajava.entities.Income;
import com.gestionfinanciera.artigoajava.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAll(){
        return incomeRepository.findAll();
    }

    public Income getById(Long id){
        Optional<Income> income = incomeRepository.findById(id);
        return income.get();
    }
}
