package br.edu.maurigvs.hrpayroll.resources;

import br.edu.maurigvs.hrpayroll.entities.Payment;
import br.edu.maurigvs.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPaymentByWorkerId(@PathVariable long workerId, @PathVariable int days){
        Payment payment = service.getPayment(workerId, days);
        return ResponseEntity.ok().body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(long workerId, int days){
        Payment payment = new Payment("Bran", 400.0, days);
        return ResponseEntity.ok().body(payment);
    }
}
