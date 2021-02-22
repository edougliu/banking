package com.segovia.banking;

import com.segovia.banking.client.AuthApiClient;
import com.segovia.banking.client.PayApiClient;
import com.segovia.banking.client.PaymentStatusApiClient;
import com.segovia.banking.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BankingApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}
}
