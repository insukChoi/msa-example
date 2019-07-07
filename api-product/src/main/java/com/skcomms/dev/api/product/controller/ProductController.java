package com.skcomms.dev.api.product.controller;

import com.skcomms.dev.api.product.model.ProductDto;
import com.skcomms.dev.api.product.model.ProductMapper;
import com.skcomms.dev.api.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/v1/product", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<ProductDto>> allProducts() {

        return ResponseEntity.ok(this.productService.find());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> findProduct(@PathVariable String id) {

        return ResponseEntity.ok(productService.findOne(id));
    }
}
