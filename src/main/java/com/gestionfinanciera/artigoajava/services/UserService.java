package com.gestionfinanciera.artigoajava.services;

import com.gestionfinanciera.artigoajava.entities.User;
import com.gestionfinanciera.artigoajava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public User insertar(User user){
        return userRepository.save(user);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User user){
        User currentUser = userRepository.getReferenceById(id);
        currentUser.setNombre(user.getNombre());
        currentUser.setEmail(user.getEmail());
        currentUser.setPwd(user.getPwd());
        return userRepository.save(currentUser);
    }
}
