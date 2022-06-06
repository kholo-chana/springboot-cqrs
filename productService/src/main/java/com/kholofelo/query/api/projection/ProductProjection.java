package com.kholofelo.query.api.projection;

import com.kholofelo.command.api.data.Product;
import com.kholofelo.command.api.model.ProductRepository;
import com.kholofelo.command.api.model.ProductRestModel;
import com.kholofelo.query.api.queries.GetProductsQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery){

        List<Product> products = productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .quantity(product.getQuantity())
                                .price(product.getPrice())
                                .name(product.getName())
                                .build())
                        .collect(Collectors.toList());
        return productRestModels;
    }
}
