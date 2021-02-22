package com.segovia.banking.client;
import com.segovia.banking.domain.Payment;
import com.segovia.banking.domain.PaymentResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PayApiClient {
    private WebClient client = WebClient.create("http://127.0.0.1:7902");

    public Mono<PaymentResponse> postPayment(Payment payment, String token) {

        Mono<PaymentResponse> result = client.post()
                .uri("/pay")
                .headers(headers -> headers.setBearerAuth(token))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(payment.asJson()))//or should this just be a string?
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(PaymentResponse.class)
                .onErrorResume(e -> handleError(e));

            return result;
        }

        private Mono<PaymentResponse> handleError(Throwable e) {
            System.out.println("something failed in call to /pay");
            e.printStackTrace();
            PaymentResponse response = new PaymentResponse();
            return Mono.just(response);
        }

}
