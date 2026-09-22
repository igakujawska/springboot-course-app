package com.example.springbootkursapp.model;

//model tylko opisuje dane, a repo to menadzer z dostepem do zarzadzania tymi danymi
//MVC to model view controller, czyli mamy dane, które kontroluje controller, i to piszemy w widoku Angularze/Vue/React
//konwencja, że w folderze model nie uzywamy koncowki model w nazwie
//JPA - specyfikacja, okresla jak nazywaja sie adnotacje, natomiast hibernate je implementuje do bazy

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity //entity to byt/jednostka z własna tozsamoscia zmieniajaca w tabele
@Table(name = "users")
public class User implements UserDetails {
    @Id //identyfikator
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoikrementacja, czyli ciagle ++1
    private int id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private Role role;

//aby przejsc do sql mamy HIBERNATE, a do tego potrzebne constructory, gettery i settery
    public User() {
    }

    public User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String email, String username, String password, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
        //rola czy tam pozwolenie
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

