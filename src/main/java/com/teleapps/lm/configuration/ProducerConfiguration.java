package com.teleapps.lm.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

public class ProducerConfiguration 
{
	private static final String KAFKA_BROKER ="localhost:9092";
	
	@Bean
	public ProducerFactory<String,String> producerFactory()
	{
		return new DefaultKafkaProducerFactory<>(ProducerConfiguration());
	}
	
	@Bean
	public Map<String, Object> ProducerConfiguration(){
		Map<String, Object> configurations=new HashMap<>();
		
		configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
		configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return configurations;
		
	}
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerFactory());
	}
}
