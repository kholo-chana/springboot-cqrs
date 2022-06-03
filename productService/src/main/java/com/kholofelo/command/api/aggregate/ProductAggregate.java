package com.kholofelo.command.api.aggregate;

import com.kholofelo.command.api.command.CreateProductCommand;
import com.kholofelo.command.api.events.ProductCreatedEvent;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregate(CreateProductCommand createProductCommand) {

        //perform all the validation
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();

        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
    }

    public ProductAggregate() {
    }
}
