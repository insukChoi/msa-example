package com.skcomms.dev.api.product.service;

import com.skcomms.dev.api.product.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> find();
    ProductDto findOne(String id);
}
