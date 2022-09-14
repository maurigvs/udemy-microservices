package br.edu.maurigvs.hrpayroll.services;

import br.edu.maurigvs.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        // Mock
        return new Payment("Bob", 100.0, days);
    }
}
