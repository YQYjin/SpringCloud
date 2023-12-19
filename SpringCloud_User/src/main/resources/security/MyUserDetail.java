package com.example.distributedhomework2.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUserDetail extends User {
    private int userID;
    public MyUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserID(){
        return userID;
    }
}
