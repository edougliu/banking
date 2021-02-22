package com.segovia.banking.service;

import com.segovia.banking.domain.Payment;
import javafx.util.converter.BigDecimalStringConverter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoaderService {
    public List<Payment> loadData() throws IOException {
        //could use POI

        String callbackUrl = "http://host.docker.internal:8080/paymentCallback/";
        List payments =  new ArrayList<Payment>();
        String[] HEADERS = {"ID", "Recipient", "Amount", "Currency"};
        Reader file = new FileReader("./sample-input.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(file);

        for (CSVRecord record : records) {
            Double amountD = Double.parseDouble(record.get("Amount"));
            BigDecimal amount = BigDecimal.valueOf(amountD);
            String ID = record.get("ID");
            Payment payment = new Payment(ID, record.get("Recipient"), amount,
                    record.get("Currency"), callbackUrl + ID);
            payments.add(payment);
        }
        return payments;
    }
}
