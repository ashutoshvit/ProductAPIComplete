package com.qy.ProductDetails.Service;

import java.util.List;

import com.qy.ProductDetails.Entiry.ProductDetails;

public interface ProductDetailsService {

	void saveProductDetails(ProductDetails productDetails);

	List<ProductDetails> getProductDetails(Long id);
	
	void deleteProduct(Long id);

	List<ProductDetails> updateProductInfo(Long id, ProductDetails productDetails);
	

}
