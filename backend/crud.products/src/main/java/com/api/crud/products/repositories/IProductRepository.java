package com.api.crud.products.repositories;
import  com.api.crud.products.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductModel, Long> {


    List<ProductModel> findByName(String product);
}
