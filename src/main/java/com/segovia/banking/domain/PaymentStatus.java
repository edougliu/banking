package com.segovia.banking.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentStatus {

    int status; //Status of request. See "Status" section.
    String timestamp; //ISO 8601 timestamp of the request.
    String reference; //ID of the conversation.
    String message;//Additional information about the status.
    String customerReference; //Identifier for this payment request.
    BigDecimal fee; //Fee for the payment.

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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
