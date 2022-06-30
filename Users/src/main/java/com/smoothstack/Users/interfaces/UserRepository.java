package com.smoothstack.Users.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smoothstack.Users.models.User;
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
