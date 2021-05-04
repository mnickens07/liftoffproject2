package org.launchcode.liftoffproject2.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity//without this annotation I was getting this error. Caused by: java.lang.IllegalArgumentException: Not a managed type: class org.launchcode.liftoffproject2.models.User
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User (){}

    public User (String username, String password){
        this.username=username;
        this.pwHash=encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean  isMatchingPassword(String password){
        return encoder.matches(password, pwHash);
    }
}
