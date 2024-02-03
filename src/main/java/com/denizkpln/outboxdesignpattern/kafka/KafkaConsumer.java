package com.denizkpln.outboxdesignpattern.kafka;


import com.denizkpln.outboxdesignpattern.model.OutBoxMessageCDC;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(
            topics = "outbox.public.outbox",
            groupId = "outbox-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void outboxListener(
            @Payload OutBoxMessageCDC outBoxMessageCDC,
            @Headers ConsumerRecord consumerRecord) throws JsonProcessingException {

        logger.info("Kafka Consumer start -- >> \n topic : {}, \n partition : {}, \n offset : {}, \n payload : {}",
                consumerRecord.topic(),
                consumerRecord.partition(),
                consumerRecord.offset(),
                outBoxMessageCDC.getAfter().getPayload());
        String value = (String) outBoxMessageCDC.getAfter().getPayload();
        //final OracleDatabase payload = objectMapper.readValue(value, OracleDatabase.class);
        System.out.println(value);
    }
}
