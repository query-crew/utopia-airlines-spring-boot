package com.smoothstack.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smoothstack.models.User;
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
