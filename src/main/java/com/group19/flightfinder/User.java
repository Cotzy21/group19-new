package com.group19.flightfinder;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userId", nullable= false)
    private long userId;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name ="passwordHash", nullable= false)
    private String passwordHash;

    String[] roles = new String[]{};

    public User(){}

    public long getUserId(){return userId;}

    public String getUsername(){return username;}

    public String getPasswordHash(){return passwordHash;}

    public void setId(long userId){
        this.userId = userId;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPasswordHash(String passwordHash){
        this.passwordHash= passwordHash;
    }

}
