package com.ipn.practicacrud.repository.Usuario;

import com.ipn.practicacrud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
