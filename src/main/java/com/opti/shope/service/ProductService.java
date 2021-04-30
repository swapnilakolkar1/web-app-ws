package com.opti.shope.service;

import java.util.List;

import com.opti.shope.shared.dto.ProductDto;

public interface ProductService {
	public boolean addNewProduct(ProductDto productDto, String userId);

	public List<ProductDto> fetchProductByUserId(String userId);
}
