package com.opti.shope.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Product_Image")
public class ProductImagesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long proImageId;
	
	@ManyToOne()  @JoinColumn(name = "productId" ,nullable = false )
	private ProductEntity productEntity;
	
	@Lob @Column(nullable = false)
	private byte productImage[];
	
	@Column(length = 40)
	private String proImgFileName;
	@Column(nullable = false)
	private String proImgFileFormat;
	
	public long getProImageId() {
		return proImageId;
	}
	public void setProImageId(long proImageId) {
		this.proImageId = proImageId;
	}
	public ProductEntity getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	public String getProImgFileName() {
		return proImgFileName;
	}
	public void setProImgFileName(String proImgFileName) {
		this.proImgFileName = proImgFileName;
	}
	public String getProImgFileFormat() {
		return proImgFileFormat;
	}
	public void setProImgFileFormat(String proImgFileFormat) {
		this.proImgFileFormat = proImgFileFormat;
	}

}
