package com.qy.ProductDetails.Entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long productId;
	@Column
	private String productname;
	@Column 
	private String productType;
	@Column
	private String productPrice;
	@Column 
	private String productCatagory;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCatagory() {
		return productCatagory;
	}
	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}
	@Override
	public String toString() {
		return "ProductDetails [productId=" + productId + ", productname=" + productname + ", productType="
				+ productType + ", productPrice=" + productPrice + ", productCatagory=" + productCatagory + "]";
	}
	public ProductDetails() {
		super();
	
	}
	public ProductDetails(long productId, String productname, String productType, String productPrice,
			String productCatagory) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productCatagory = productCatagory;
	}
	
}
