package com.opti.shope.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = 9106626313025827789L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	private String userId;

	private String productName;
	private String productDecription;
	private int productQty;
	private Double productPrice;

	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "productEntity")
	private List<ProductImagesEntity> images;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDecription() {
		return productDecription;
	}

	public void setProductDecription(String productDecription) {
		this.productDecription = productDecription;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public List<ProductImagesEntity> getImages() {
		return images;
	}

	public void setImages(List<ProductImagesEntity> images) {
		this.images = images;
	}


}
