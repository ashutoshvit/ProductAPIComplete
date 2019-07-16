package com.qy.ProductDetails.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qy.ProductDetails.Entiry.ProductDetails;
import com.qy.ProductDetails.Exception.ProductDetailsException;
import com.qy.ProductDetails.Service.ProductDetailsServiceImpl;

@RestController
public class ProductDetailsController {

	private static Logger LOGGER=LoggerFactory.getLogger(ProductDetailsController.class);
	@Autowired
	ProductDetailsServiceImpl productDetailsServiceImpl;
	
	@PostMapping("/productRegistration")
	public String registerProduct(@RequestBody ProductDetails productDetail)
	{
		LOGGER.info("-------------------------Saving Product Information into Database--------------------------");
		
		
		productDetailsServiceImpl.saveProductDetails(productDetail);
		
		return "Success";
	}
	@GetMapping("/productInfo/{id}")
	public List<ProductDetails> productInfo(@PathVariable Long id) {
		LOGGER.info("----------------------------------Searching Product Information by Id----------------------------------");
		List<ProductDetails> product=productDetailsServiceImpl.getProductDetails(id);
		return product;
	}
	@DeleteMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable Long id) {
		LOGGER.info("Deleting Product id"+id);
		productDetailsServiceImpl.deleteProduct(id);
		return "Product Deleted Successfully";
	}
	@PutMapping("/productInfo/{id}")
	public List<ProductDetails> updateProductInfo(@RequestBody ProductDetails productupdate,@PathVariable("id") Long id){
		LOGGER.info("Updating Product Details"+id);
		
		List<ProductDetails> productInfo= productDetailsServiceImpl.updateProductInfo(id,productupdate);
		return productInfo;
	}
	
}

