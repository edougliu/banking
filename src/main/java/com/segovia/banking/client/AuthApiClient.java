package com.segovia.banking.client;
import com.segovia.banking.domain.Account;
import com.segovia.banking.domain.Token;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class AuthApiClient {
    private WebClient client = WebClient.create("http://127.0.0.1:7902");

    public Mono<Token> authorize(Account account) {

        return client.post()
                .uri("/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Api-Key", account.getApiKey())
                .body(BodyInserters.fromValue(account.asJson()))//or should this just be a string?
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Token.class);
        }

}
