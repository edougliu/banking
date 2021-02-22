package com.segovia.banking.service;

import com.segovia.banking.client.AuthApiClient;
import com.segovia.banking.client.PayApiClient;
import com.segovia.banking.client.PaymentStatusApiClient;
import com.segovia.banking.domain.Account;
import com.segovia.banking.domain.Payment;
import com.segovia.banking.domain.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class BankServiceTest {

    @InjectMocks
    BankService bankService; //= new BankService();

    @Spy
    DataLoaderService dataLoaderService;

    @Spy
    AuthApiClient authApiClient;

    @Spy
    PayApiClient payApiClient;

    @Spy
    PaymentStatusApiClient paymentStatusApiClient;

    @Test
    public void makePayment() throws IOException {
        //List<PaymentResponse> responses =
                bankService.postPayments();
        //assertNotNull(responses);
//        for (PaymentResponse response: responses) {
//            System.out.println(response.asJson());
//        }
    }
}
