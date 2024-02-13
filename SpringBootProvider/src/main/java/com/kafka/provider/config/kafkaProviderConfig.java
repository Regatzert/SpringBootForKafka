package com.kafka.provider.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;
import java.util.HashMap;
@Configuration
public class kafkaProviderConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServers;


    public Map<String, Object> producerConfig(){
        Map<String, Object> propiedad = new HashMap<>();
        propiedad.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers);  //clase donde se especifica la ruta del servidor de kafka
        propiedad.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); //clase que se encarga de serializar los mensajes a enviar
        propiedad.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); //clase que se encargar de serializar el objeto
        return propiedad;
    }

    @Bean
    public ProducerFactory<String, String> providerFactory(){
    return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> providerFactory){
        return new KafkaTemplate<>(providerFactory);
    }

    

}
