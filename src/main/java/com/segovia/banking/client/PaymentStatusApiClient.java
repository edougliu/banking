package com.segovia.banking.client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.segovia.banking.domain.Payment;
import com.segovia.banking.domain.PaymentResponse;
import com.segovia.banking.domain.PaymentStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentStatusApiClient {
    private WebClient client = WebClient.create("http://127.0.0.1:7902");

    public Mono<PaymentStatus> getPaymentStatus(String conversationID, String token) {
        System.out.println("using token: " + token);
        Mono<PaymentStatus> result = client.get()
                .uri("/status/" + conversationID)
                .headers(headers -> headers.setBearerAuth(token))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PaymentStatus.class);
            return result;
        }
}
