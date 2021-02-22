package com.segovia.banking.domain;

import org.springframework.stereotype.Component;

//code is a decimal ...???
public enum Status {
    SUCCESS(0, "Transaction succeeded."),
    PENDING(100,"Transaction pending."),
    INVALID(1000,"Invalid request."),
    PHONE_INVALID(20000,"Recipient phone number was not valid."),
    RECIPIENT_ACCOUNT_LOCKED(20001,"Recipient account is locked."),
    SENDER_ACCOUNT_LOCKED(20002,"Sender account is locked."),
    WALLET_FULL(20003,"Recipient wallet is full."),
    INSUFFICIENT_BALANCE(20004,"Insufficient balance in sender account."),
    TEMP_FAILURE(20005, "Temporary failure."),
    BAD_PHONE(20014,"Recipient phone number isn't registered for mobile money."),
    DUPLICATE_REFERENCE(30006, "Duplicate reference.");

    private int code;
    private String text;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    Status(int code, String text){
        this.text = text;
        this.code = code;
    }

    public static Status getStatus(int code) {
        for (Status status : Status.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }
}
