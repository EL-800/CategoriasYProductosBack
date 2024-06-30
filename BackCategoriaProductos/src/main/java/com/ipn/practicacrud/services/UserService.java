package com.ipn.practicacrud.services;

import com.ipn.practicacrud.models.User;

public interface UserService {
    public User RegisterUser(User user);
    public User updateUser(int id, User user);
    public User getUserById(int id);
    public Boolean deleteUser(int id);
}
