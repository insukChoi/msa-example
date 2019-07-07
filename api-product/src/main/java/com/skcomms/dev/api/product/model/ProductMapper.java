package com.skcomms.dev.api.product.model;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper instance = Mappers.getMapper(ProductMapper.class);

    ProductDto productToProductDto(Product product);
    List<ProductDto> productsToProductDtos(List<Product> products);
}
