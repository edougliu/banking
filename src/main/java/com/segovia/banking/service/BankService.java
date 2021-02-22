package com.segovia.banking.service;

import com.segovia.banking.client.AuthApiClient;
import com.segovia.banking.client.PayApiClient;
import com.segovia.banking.client.PaymentStatusApiClient;
import com.segovia.banking.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    @Autowired
    AuthApiClient authApiClient;

    @Autowired
    PayApiClient payApiClient;

    @Autowired
    PaymentStatusApiClient paymentStatusApiClient;

    @Autowired
    DataLoaderService dataLoaderService;

    public void postPayments() throws IOException {
        List<Payment> payments = dataLoaderService.loadData();
        Account account = new Account("SEGOVIA","0aVp83wuFp6wjvQ3");
        authApiClient.authorize(account)
                .subscribe(token -> postPayment(payments, token.getToken()));
    }

    private void postPayment(List<Payment> payments, String token) {
        List<PaymentResponse> responses = new ArrayList<PaymentResponse>();
        for (Payment payment: payments) {
            Mono<PaymentResponse> responseMono = payApiClient.postPayment(payment, token);
            responseMono.subscribe(response -> getPaymentResponse(response, token));
        }
    }

    private void getPaymentResponse(PaymentResponse response, String token) {
        System.out.println(response.asJson());
        if (response.getConversationID() != null && response.getStatus() != 0) {
            checkPaymentStatus(response.getConversationID(), token);
        }
    }

    private void checkPaymentStatus(String conversationID, String token) {
        Mono<PaymentStatus> paymentStatusMono = paymentStatusApiClient.getPaymentStatus(conversationID, token);
        //figure out how to accumulate all the statuses
        paymentStatusMono.subscribe(status -> gatherPaymentStatuses(status));
    }

    public void gatherPaymentStatuses(PaymentStatus status) {
            System.out.println(status.asJson());
    }
}
