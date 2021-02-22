package com.segovia.banking.domain;

import org.springframework.stereotype.Component;

@Component
public class Token {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
}
