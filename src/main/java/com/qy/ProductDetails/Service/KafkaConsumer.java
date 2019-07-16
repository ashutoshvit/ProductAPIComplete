package com.qy.ProductDetails.Service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.qy.ProductDetails.Constant.Constant;
import com.qy.ProductDetails.Dao.ProductDetailsDao;
import com.qy.ProductDetails.Entiry.ProductDetails;

public class KafkaConsumer {

	@Autowired
	ProductDetailsDao productDetaildao;
	
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	

	
	@Transactional
	@KafkaListener(topics = Constant.topic, groupId="productId")
	public void recieveMessage(ProductDetails productDetails) {
		productDetaildao.save(productDetails);
	}
}
