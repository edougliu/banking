package com.segovia.banking.controller;

import com.segovia.banking.domain.PaymentResponse;
import io.netty.handler.codec.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentCallback {
    @GetMapping("/paymentCallback/{ID}")
    public String callback(@PathVariable String ID) {
        //TODO figure out what the provider api is going to send back...
        //TODO figure out the conversationID and check status
        System.out.println("got call back reference ID:" + ID + "is done");
        return "got call back: " + ID + "is done";
    }
}
