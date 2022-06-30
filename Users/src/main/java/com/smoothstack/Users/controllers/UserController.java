package com.smoothstack.Users.controllers;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.Users.services.UserService;


@RestController
public class UserController {
    @RequestMapping("/users")
    public String getAllUsers() throws SQLException{
        return UserService.getAllUsers().toString();
    }
    

    @RequestMapping("/users/{userId}")
    public String getUserById(@PathVariable int userId, String tableName) throws SQLException {
        tableName = "tbl_users";
        return UserService.getUserById(userId).toString();
    }

    @RequestMapping("/")
        public String Hello() throws SQLException {
            return "Hello from user microservice";
        }
    
}
