package com.gestionfinanciera.artigoajava.repositories;

import com.gestionfinanciera.artigoajava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
