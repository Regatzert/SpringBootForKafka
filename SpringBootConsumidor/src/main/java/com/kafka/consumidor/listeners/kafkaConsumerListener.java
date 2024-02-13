package com.kafka.consumidor.listeners;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;



@Configuration
public class kafkaConsumerListener {
    
    private Logger logger = LoggerFactory.getLogger(kafkaConsumerListener.class);

    @KafkaListener(topics = {"Primer-Topico-con-kafka"}, groupId = "Grupo1") //Mapeado de kafka para el o los topicos, siempre debe existir un groupId para que funcione
    public void listener(String messagge){
        logger.info("mensaje recibido, el mensaje es: ", messagge);
    }
}
