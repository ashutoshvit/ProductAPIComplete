package com.qy.ProductDetails.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qy.ProductDetails.Entiry.ProductDetails;
@Repository
public interface ProductDetailsDao extends JpaRepository<ProductDetails, Long> {

	@Query("select pd from ProductDetails pd where pd.id=:id")
	List<ProductDetails> findByProductId(@Param("id")Long id);
	
	@Query("DELETE FROM ProductDetails pd WHERE pd.id=id")
	ProductDetails deleteProduct(@Param("id")Long id);
	
	@Modifying
	@Query("update from ProductDetails pd set pd.id=id")
	List<ProductDetails> updateProductInfo(@Param("id")Long id);

}
