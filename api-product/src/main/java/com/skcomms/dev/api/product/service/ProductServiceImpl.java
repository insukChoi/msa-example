package com.skcomms.dev.api.product.service;

import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.product.model.Product;
import com.skcomms.dev.api.product.model.ProductDto;
import com.skcomms.dev.api.product.model.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    ProductServiceImpl(ProductRepository repository)
    {
        this.productRepository=repository;
    }

    @Override
    public List<ProductDto> find() {
        return ProductMapper.instance.productsToProductDtos(productRepository.findAll());
    }

    @Override
    public ProductDto findOne(String productId) {
       return ProductMapper.instance.productToProductDto(productRepository.findOne(productId));
    }
}
