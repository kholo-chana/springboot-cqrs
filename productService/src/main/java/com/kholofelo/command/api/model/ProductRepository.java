package com.kholofelo.command.api.model;

import com.kholofelo.command.api.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
