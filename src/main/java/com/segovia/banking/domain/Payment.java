package com.segovia.banking.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Payment {
    private String msisdn;  //Recipient phone number.
    private BigDecimal amount; //Amount to pay.
    private String currency;//ISO-4217 currency code of amount.
    private String reference; //Client-supplied identifier for this payment.
    private String url;   //URL to send callback request with payment result.

    //ID,Recipient,Amount,Currency
    public Payment(String reference, String msisdn, BigDecimal amount, String currency, String url) {
        this.msisdn = msisdn;
        this.amount = amount;
        this.currency = currency;
        this.reference = reference;
        this.url = url;
    }

    public Payment() {}

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String asJson() {
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace(); //log
        }
        return json;
    }
}
