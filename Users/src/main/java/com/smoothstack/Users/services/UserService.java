package com.smoothstack.Users.services;

import java.sql.*;
import java.util.*;
import com.smoothstack.Users.connector.DBConnection;
import com.smoothstack.Users.models.User;


public class UserService {
    public static List<User> getAllUsers() throws SQLException {

        List<User> list = new ArrayList<>();

        String query = "SELECT * FROM users";
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        try {
            while (rs.next()) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static User getUserById(int userId) throws SQLException {

        User user = null;

        String query = "SELECT * FROM users WHERE userId =" + userId;
        Statement st = DBConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery(query);
        try {
            if(rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return user;
            }else{
                user = null;
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return user;
        
    }

    public static void addUser(int id, String username, String email, String password) throws SQLException{

        
        String query = "INSERT INTO users (id, username, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = null;

        try {
            pst = DBConnection.getConnection().prepareStatement(query);
            
    
                pst.setInt(1, id);
                pst.setString(2, username);
                pst.setString(3, email);
                pst.setString(4, password);
                
            
            int number = pst.executeUpdate();

            if (number > 0) {
                System.out.println("SUCCESSFULL INSERT");
            } else {
                System.out.println("INSERT FAILED");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteUserById(Integer userId, String tableName) {

        
        String query = "DELETE FROM "+ tableName + " WHERE id = ?";
        PreparedStatement pst = null;

        try {
            pst = DBConnection.getConnection().prepareStatement(query);
           
                pst.setInt(1, userId);

            int result = pst.executeUpdate();

            if (result > 0) {
                System.out.println("Successfully deleted user with id " + userId);
            } else {
                System.out.println("The user with id " + userId + " was not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void updateUser(int userId, String username, String email) throws SQLException {

        String query = "UPDATE users SET userId = ?, username = ?, email = ? WHERE userId = ?";
        PreparedStatement pst = null;

        try {

            pst = DBConnection.getConnection().prepareStatement(query);

            
                pst.setInt(1, userId);
                pst.setString(2, username);
                pst.setString(3, email);
   

            int result = pst.executeUpdate();

            if (result > 0) {
                System.out.println("Successfully updated user with id " + userId);
            } else {
                System.out.println("User update unsuccessful");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pst.close();
                DBConnection.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void createUserTable(String tableName) {
        String query = "CREATE TABLE " + tableName + "(userId INT, userName VARCHAR(45), , password VARCHAR(100), PRIMARY KEY(userId))";
        PreparedStatement pst = null;
        try {
            pst = DBConnection.getConnection().prepareStatement(query);
    
            if(pst.execute()) {
                System.out.println("User Table Created: " + tableName);
            }
        }
        catch(SQLException _ex) {
            System.out.println(_ex.getMessage());
        }
    }

    

}
