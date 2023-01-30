package com.example.shipment;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {

    private static final String TOPIC_NAME = "checkout.complete.v1";

    private static final String GROUP_ID = "shipment.group.v1";

    private final SaveService saveService;
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void recordListener(String jsonMessage) {
        try {
            CheckOutDto checkOutDto = objectMapper.readValue(jsonMessage, CheckOutDto.class);
            log.info(checkOutDto.toString());
            saveService.saveCheckOutData(checkOutDto);
        } catch (Exception e) {
            log.error("recordListener ERROR message = {}", jsonMessage, e);
        }
    }
}
