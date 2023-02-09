package com.hai.minh.epservice.processor.message;

import com.hai.minh.epservice.commons.constants.RabbitConstants;
import com.hai.minh.epservice.service.EPProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerEPProduct {

    @Autowired
    private EPProductService epProductService;

    @RabbitListener(queues = RabbitConstants.QUEUE_CREATE_EP_PRODUCT)
    public void receiveMessage(String message) {
        log.info("receiveMessage: {}", message);
//        epProductService.processorCreateProductToEP(message);
    }
}