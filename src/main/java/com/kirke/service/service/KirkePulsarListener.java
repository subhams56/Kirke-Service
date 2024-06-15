package com.kirke.service.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KirkePulsarListener {

    @Autowired
    private PulsarClient pulsarClient;

    @Value("${pulsar.topic.service.url}")
    private String serviceUrl;

    @Value("${pulsar.topic.name}")
    private String topicName;

    @Value("${pulsar.topic.subscription.name}")
    private String subscriptionName;

    private Consumer<byte[]> consumer;



    public void startListener() throws PulsarClientException {
        if (consumer == null) {
            consumer = pulsarClient.newConsumer()
                    .topic(topicName)
                    .subscriptionName(subscriptionName)
                    .subscriptionType(SubscriptionType.Shared)
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                    .messageListener((consumer1, msg) -> {
                        try {
                            String message = new String(msg.getData());
                            log.info("Received Geofences From Topic : {}",topicName);
                            if ((isJsonObject(message))&&(message.contains("\"activityTypeName\": \"CONFIGURATION CHANGE\""))) {


                                log.info("Kirke Message: {}", message);


                            }else{
                                log.info("Message is not a valid JSON Object");
                            }



                            consumer1.acknowledge(msg);

                        } catch (Exception e) {
                            e.printStackTrace();
                            consumer1.negativeAcknowledge(msg);
                        }
                    })
                    .subscribe();
            // Seek to the earliest message to read all existing messages
            consumer.seek(MessageId.earliest);
            log.info("Pulsar listener started");
        } else {
            log.info("Pulsar listener is already running. List Size");
        }
    }

    public void stopListener() {
        if (consumer != null) {
            try {
                consumer.close();
                consumer = null;
                log.info("Pulsar listener stopped.");
            } catch (PulsarClientException e) {
                e.printStackTrace();
                log.error("Failed to stop Pulsar listener.", e);
            }
        } else {
            log.info("Pulsar listener is not running.");
        }
    }

    public boolean isJsonObject(String json){
        try{

            JSONObject jsonObject = new JSONObject(json);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
