package com.gestionfinanciera.artigoajava.repositories;

import com.gestionfinanciera.artigoajava.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
