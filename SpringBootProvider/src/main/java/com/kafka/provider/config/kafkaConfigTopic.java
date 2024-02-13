package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;
import java.util.HashMap;
@Configuration
public class kafkaConfigTopic {

    @Bean
    public NewTopic generateTopic(){

        Map<String,String> configuruacion = new HashMap<>();
        configuruacion.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //delete (borra mensaje), compact (mantiene el mensaje mas actual)
        configuruacion.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // 1 day in ms - tiempo de retencion de mensajes por defecto -1 (no se borran los mensajes)
        configuruacion.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // 1 GB tamano maximo del segmento, por defecto 1 GB
        configuruacion.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760"); // 10MB tamano maximo de cada mensaje, por defecto viene en 1MB
    
        return TopicBuilder.name("Primer-Topico-con-kafka")
        .partitions(2) //numero de particiones, si no se indica se toma por defecto 
        .replicas(2)   //numero de replicas, si no se indica se toman las configur
        .configs(configuruacion) //agregar configuración a nivel de topic por el metodo MAP<>
        .build();
    }
}
