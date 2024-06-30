package com.ipn.practicacrud.services.impl;

import com.ipn.practicacrud.models.User;
import com.ipn.practicacrud.repository.Usuario.UserRepository;
import com.ipn.practicacrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User RegisterUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int id, User user) {
        User currentUser = userRepository.findById(id).orElse(null);
        if(currentUser == null)
            return null;

        currentUser.setNombre(user.getNombre());
        currentUser.setPaterno(user.getPaterno());
        currentUser.setMaterno(user.getMaterno());
        currentUser.setEmail(user.getEmail());
        userRepository.save(currentUser);

        return currentUser;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteUser(int id) {
        User currentUser = userRepository.findById(id).orElse(null);
        if(currentUser == null)
            return false;
        userRepository.delete(currentUser);
        return true;
    }
}
