package com.segovia.banking.client;

import com.segovia.banking.domain.Payment;
import com.segovia.banking.domain.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PayApiClientTest {
    PayApiClient payApiClient = new PayApiClient();
    String token = "3b72b58b-7a48-42a0-9522-9d58ee531d1d";
    String callbackUrl = "http://host.docker.internal:8080/paymentCallback/";

    @Test
    public void testPostPayment() {
        //need proper token - mock?
        //also need to handle expired tokens
        Payment payment = new Payment("123", "234", new BigDecimal(120.00), "USD",
                "http://host.docker.internal:8080/paymentCallback/" + "123");
        Mono<PaymentResponse> response = payApiClient.postPayment(payment, token);
    }
}
