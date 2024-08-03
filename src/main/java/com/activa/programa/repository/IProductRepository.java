package com.activa.programa.repository;

import com.activa.programa.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long> {
    ProductModel findByProductName(String name);
}