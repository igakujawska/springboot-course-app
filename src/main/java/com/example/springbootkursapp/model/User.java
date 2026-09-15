package com.example.springbootkursapp.model;

//MVC to model view controller, czyli mamy dane, które kontroluje controller, i to piszemy w widoku Angularze/Vue/React
//konwencja, że w folderze model nie uzywamy koncowki model w nazwie
public class User {
    private int id;
    private String username;
    private String password;
    private String email;

//aby przejsc do sql mamy HIBERNATE, a do tego potrzebne constructory, gettery i settery
    public User() {
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
