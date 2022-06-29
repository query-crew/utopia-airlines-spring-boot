package com.smoothstack.models;

public class User {
    private Integer id;
    private String userName;
    private String email;
    private String password;

    public User(int id, String userName, String email, String password){
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(){}

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassHashed() {
        return password;
    }

    public void setPassHashed(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + id + ", userName=" + userName + ",email=" +email + ", password=" + password +'}';
    }
}
