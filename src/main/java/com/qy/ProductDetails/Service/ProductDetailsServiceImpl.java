package com.qy.ProductDetails.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qy.ProductDetails.Dao.ProductDetailsDao;
import com.qy.ProductDetails.Entiry.ProductDetails;


@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);
	@Autowired
	ProductDetailsDao productDetailsDao;

	@Autowired
	KafkaProducer sender;

	@Override
	public void saveProductDetails(ProductDetails productDetails) {
		productDetailsDao.save(productDetails);
	}

	@Override
	public List<ProductDetails> getProductDetails(Long id) {
		List<ProductDetails> productInfo = productDetailsDao.findByProductId(id);

		return productInfo;

	}

	@Override
	public void deleteProduct(Long id) {
		productDetailsDao.deleteById(id);
		LOGGER.info("Product deleted Successfully", id);
	}

	
	@Override
	public List<ProductDetails> updateProductInfo(Long id,ProductDetails productDetails) {
		List<ProductDetails> productupdateInfo=productDetailsDao.updateProductInfo(id);
		for(int i=0;i<productupdateInfo.size();i++) {
			ProductDetails t=productupdateInfo.get(i);
			if(t.getProductId()==id) {
				productupdateInfo.set(i,productDetails);
			}
			
		}
		return productupdateInfo;
	}

}
