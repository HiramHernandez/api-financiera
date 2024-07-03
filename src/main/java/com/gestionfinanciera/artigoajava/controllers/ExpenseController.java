package com.gestionfinanciera.artigoajava.controllers;
import com.gestionfinanciera.artigoajava.entities.Expense;
import com.gestionfinanciera.artigoajava.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getAll() {
        List<Expense> expenses = expenseService.getAll();
        return ResponseEntity.ok().body(expenses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Expense> getById(@PathVariable Long id) {
        Expense expense = expenseService.getById(id);
        return ResponseEntity.ok().body(expense);
    }
}
