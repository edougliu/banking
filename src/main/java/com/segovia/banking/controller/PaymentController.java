package com.segovia.banking.controller;

import com.segovia.banking.domain.Account;
import com.segovia.banking.domain.PaymentResponse;
import com.segovia.banking.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    BankService bankService;

    @GetMapping("/payment")
    public void makePayments() throws IOException {
        //List<PaymentResponse> statuses =
        bankService.postPayments();
        //return statuses;
    }

    @GetMapping("/paymentStatus")
    public void getPaymentStatuses(@PathVariable List<String> conversionIDs) throws IOException {
        //bankService.checkPaymentStatus(conversionIDs);
    }
}
