package com.segovia.banking;

import com.segovia.banking.client.AuthApiClient;
import com.segovia.banking.client.PayApiClient;
import com.segovia.banking.client.PaymentStatusApiClient;
import com.segovia.banking.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class BankingApplicationTests {

	@Test
	public void test() {
		AuthApiClient gwc = new AuthApiClient();
		Account account = new Account("SEGOVIA", "0aVp83wuFp6wjvQ3");
		String token = gwc.authorize(account).block().getToken();
		System.out.println("token: " + token);

		BigDecimal amount = new BigDecimal(100.00);
		String reference = "birthday money" + new Date().toString();
		Payment payment = new Payment(reference, "16128590703", amount, "GBP", null);

		PayApiClient pwc = new PayApiClient();
		Mono<PaymentResponse> paymentResponseMono = pwc.postPayment(payment, token);
		PaymentResponse paymentResponse = paymentResponseMono.block();
		System.out.println(paymentResponse.getConversationID());
		System.out.println(paymentResponse.getMessage()); //no news is good news (null means success)
		System.out.println(Status.getStatus(paymentResponse.getStatus()).getText());

		String conversationID = paymentResponse.getConversationID();
		PaymentStatusApiClient pswc = new PaymentStatusApiClient();
		Mono<PaymentStatus> paymentStatusMono = pswc.getPaymentStatus(conversationID, token);

		paymentStatusMono.subscribe(paymentStatus -> {
			System.out.println("payment status:" + paymentStatus.asJson());
			if (paymentStatus.getStatus() != 100) {
				System.out.println("done! " + Status.getStatus(paymentStatus.getStatus()).getText());
			}
		});
	}

}
