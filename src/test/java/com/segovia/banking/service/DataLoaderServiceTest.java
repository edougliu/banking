package com.segovia.banking.service;

import com.segovia.banking.domain.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class DataLoaderServiceTest {
    //@Autowired
    DataLoaderService service = new DataLoaderService();

    @Test
    public void loadData() throws IOException {
        List<Payment> payments = service.loadData();
        assertEquals(4, payments.size());
        for (Payment payment: payments) {
            System.out.println(payment.asJson());
        }
    }
}
