package br.edu.maurigvs.hrpayroll.services;

import br.edu.maurigvs.hrpayroll.entities.Payment;
import br.edu.maurigvs.hrpayroll.entities.Worker;
import br.edu.maurigvs.hrpayroll.feign.clients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.getById(workerId).getBody();
        return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }
}
