package com.qy.ProductDetails.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.qy.ProductDetails.Constant.Constant;
import com.qy.ProductDetails.Entiry.ProductDetails;

@Service
public class KafkaProducer {

	private static Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
	@Autowired
	private KafkaTemplate<String, ProductDetails> kafkaTemplate;
	
	public List<ProductDetails> sendMessage(ProductDetails productInfo) {
		this.kafkaTemplate.send(Constant.topic, productInfo);
		return null;
	}
	
	public ProductDetails sendMessage1(ProductDetails list) {
		this.kafkaTemplate.send(Constant.topic1, list);
		return null;
	}
	
}
