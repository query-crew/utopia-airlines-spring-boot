package com.smoothstack.controllers;

import java.sql.SQLException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.services.UserService;


@RestController
public class UserController {
    @RequestMapping("/users")
    public String getAllUsers() throws SQLException{
        String tableName = "users";
        return UserService.getAllUsers(tableName).toString();
    }
    

    @RequestMapping("/users/{userId}")
    public String getUserById(int userId, String tableName) throws SQLException {
        tableName = "users";
        return UserService.getUserById(userId, tableName).toString();
    }
}
