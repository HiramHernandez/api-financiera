package com.gestionfinanciera.artigoajava.config;

import com.gestionfinanciera.artigoajava.entities.Category;
import com.gestionfinanciera.artigoajava.entities.Expense;
import com.gestionfinanciera.artigoajava.entities.Income;
import com.gestionfinanciera.artigoajava.entities.User;
import com.gestionfinanciera.artigoajava.enums.ExpenseStatus;
import com.gestionfinanciera.artigoajava.enums.IncomeStatus;
import com.gestionfinanciera.artigoajava.repositories.CategoryRepository;
import com.gestionfinanciera.artigoajava.repositories.ExpenseRepository;
import com.gestionfinanciera.artigoajava.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.gestionfinanciera.artigoajava.repositories.UserRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfiguration implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User usuario1 = new User("Caio", "caio@gmail.com", "123456");
        User usuario2 = new User("Vinicius", "vinicius@gmail.com", "123456");

        userRepository.saveAll(Arrays.asList(usuario1, usuario2));


        Category categoria1 = new Category("Combustível");
        Category categoria2 = new Category("Alimentação");
        Category categoria3 = new Category("Trabalho");
        Category categoria4 = new Category("Contas mensais");

        categoryRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4));

        Income receita1 = new Income("Salário", 2900.00, Instant.now(), IncomeStatus.RECIBIDA, usuario1, categoria3);
        Income receita2 = new Income("Salário", 4000.00, Instant.now(), IncomeStatus.RECIBIDA, usuario2, categoria3);
        Income receita3 = new Income("Bônus", 500.00, Instant.now(), IncomeStatus.AGENDADO, usuario1, categoria3);

        Expense despesa1 = new Expense("Gasolina", 50.00, Instant.now(), ExpenseStatus.PAGADO, usuario1, categoria1);
        Expense despesa2 = new Expense("Conta de luz", 150.00, Instant.now(), ExpenseStatus.ATRASADA, usuario2, categoria4);
        Expense despesa3 = new Expense("Almoço", 25.00, Instant.now(), ExpenseStatus.PAGADO, usuario1, categoria2);


        incomeRepository.saveAll(Arrays.asList(receita1, receita2, receita3));
        expenseRepository.saveAll(Arrays.asList(despesa1, despesa2, despesa3));

    }
}
