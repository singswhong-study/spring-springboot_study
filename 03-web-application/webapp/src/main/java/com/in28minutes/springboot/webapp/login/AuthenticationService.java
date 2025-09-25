package com.in28minutes.springboot.webapp.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String user, String password){
        boolean isValidUserName = user.equalsIgnoreCase("test");
        boolean isVAlidPassword = password.equalsIgnoreCase("1234");
        return isValidUserName && isVAlidPassword;
    }
}
