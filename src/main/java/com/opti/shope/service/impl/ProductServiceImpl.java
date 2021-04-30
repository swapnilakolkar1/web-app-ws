package com.opti.shope.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opti.shope.io.entity.ProductEntity;
import com.opti.shope.repositories.ProductRepository;
import com.opti.shope.service.ProductService;
import com.opti.shope.shared.dto.ProductDto;
import com.opti.shope.shared.utility.CommonUtility;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepo;
	private CommonUtility<ProductEntity, ProductDto> commonUtility = new CommonUtility<>();
	private ModelMapper mp = new ModelMapper();

	@Override
	public boolean addNewProduct(ProductDto productDto, String userId) {
		// TODO Auto-generated method stub
		productDto.setUserId(userId);
		ProductEntity prodEntity = new ProductEntity();
		mp.map(productDto, prodEntity);
		ProductEntity result = productRepo.saveAndFlush(prodEntity);
		return result != null;
	}

	@Override
	public List<ProductDto> fetchProductByUserId(String userId) {
		List<ProductDto> products = new ArrayList<ProductDto>();
		List<ProductEntity> result = productRepo.findAllByUserId(userId);
		if (!result.isEmpty()) {
			products=commonUtility.mapList(result, ProductDto.class);
		}
		return products;
	}

}
