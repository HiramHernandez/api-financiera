package com.gestionfinanciera.artigoajava.controllers;

import com.gestionfinanciera.artigoajava.entities.Income;
import com.gestionfinanciera.artigoajava.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/incomes")
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @GetMapping
    public ResponseEntity<List<Income>> getAll() {
        List<Income> incomes = incomeService.getAll();
        return ResponseEntity.ok().body(incomes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Income> getById(@PathVariable Long id) {
        Income income = incomeService.getById(id);
        return ResponseEntity.ok().body(income);
    }
}
