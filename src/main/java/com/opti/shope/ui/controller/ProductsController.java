package com.opti.shope.ui.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opti.shope.service.ProductService;
import com.opti.shope.shared.dto.ProductDto;
import com.opti.shope.shared.utility.CommonUtility;
import com.opti.shope.ui.model.request.ProductDetailRequestModel;
import com.opti.shope.ui.model.response.ProductRest;

@RestController
@RequestMapping("api/v1/seller/products/list")
public class ProductsController {
	@Autowired
	ProductService productService;
	CommonUtility<ProductDto, ProductRest> commonUtil = new CommonUtility<>();
	ModelMapper modelmapper = new ModelMapper();

	@PutMapping(path = "/addNewProduct/{userId}")
	public String addNewProduct(@PathVariable String userId, @RequestBody ProductDetailRequestModel productObj,
			Principal principal) {
		// spring binds principal object to identify user, when we include it in method
		// params
		ProductDto productDto = new ProductDto();
		boolean productPersisted = false;
		if (productObj != null && userId != null) {
			modelmapper.map(productObj, productDto);
			productPersisted = productService.addNewProduct(productDto, userId);
		}
		return productPersisted == true ? "added product" : "there is some issue ";
	}

	@GetMapping(path = "/getAllProduct/{userId}")
	public List<ProductRest> getAllProduct(@PathVariable String userId) {
		List<ProductRest> productRestList = new ArrayList<>();
		if (userId != null && userId.trim() != null) {
			List<ProductDto> productDtoList = productService.fetchProductByUserId(userId);
			if (!productDtoList.isEmpty()) {
				productRestList = commonUtil.mapList(productDtoList, ProductRest.class);
//				productRestList=productDtoList.stream().
//						map(pDto->modelmapper.map(pDto, ProductRest.class))
//						.collect(Collectors.toList());

			}
		}
		return productRestList;
	}

}
