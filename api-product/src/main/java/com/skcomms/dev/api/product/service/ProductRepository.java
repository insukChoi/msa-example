package com.skcomms.dev.api.product.service;

import com.skcomms.dev.api.common.exception.DataNotFoundException;
import com.skcomms.dev.api.product.model.Product;
import com.skcomms.dev.api.product.model.ProductDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    private static List<Product> products = new ArrayList<>();

    @PostConstruct
    void init()
    {
        products.add(Product.builder().id("0001").name("우산").price(1000).build());
        products.add(Product.builder().id("0002").name("자전거").price(20000).build());
        products.add(Product.builder().id("0003").name("컴퓨터").price(3000).build());
        products.add(Product.builder().id("0004").name("신발").price(5000).build());
        products.add(Product.builder().id("0005").name("가방").price(8000).build());
    }

    public Product findOne(String productId)
    {
        return products.stream().filter(product -> productId.equalsIgnoreCase(product.getId())).findFirst().orElseThrow(
                ()->new DataNotFoundException("상품이 없습니다.")
        );
    }

    public List<Product> findAll()
    {
        return products;
    }
}
