package com.prueba.customer.service.impl;

import com.prueba.customer.repository.entity.Movimientos;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @RabbitListener(queues = "myQueue")
    public void handleMessage(Movimientos movimientos) {
        System.out.println("Tu nuevo Saldo es: : " + movimientos.getSaldo());
    }
}