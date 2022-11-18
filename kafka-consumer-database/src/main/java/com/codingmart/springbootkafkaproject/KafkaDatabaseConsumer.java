package com.codingmart.springbootkafkaproject;

import com.codingmart.springbootkafkaproject.entity.WikimediaData;
import com.codingmart.springbootkafkaproject.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private final WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikimediaData wikimediaData = WikimediaData.builder().wikiEventData(eventMessage).build();
        dataRepository.save(wikimediaData);
    }
}