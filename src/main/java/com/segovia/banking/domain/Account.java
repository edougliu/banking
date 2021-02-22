package com.segovia.banking.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Account {
    private String account;
    private String apiKey;

    public String getAccount() {
        return account;
    }

    public String getApiKey() {
        return apiKey;
    }

    public Account() {}

    public Account(String accountId, String apiKey) {
        this.account = accountId;
        this.apiKey = apiKey;
    }
    public String asJson() {
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace(); //logger instead
        }
        return json;
    }
}
