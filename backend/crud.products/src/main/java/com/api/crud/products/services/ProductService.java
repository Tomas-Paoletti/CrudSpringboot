package com.api.crud.products.services;

import com.api.crud.products.models.ProductModel;
import com.api.crud.products.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {


    @Autowired
    IProductRepository productRepository;

    public ProductModel saveProduct(ProductModel product){
        return productRepository.save(product);
    }
    public List<ProductModel> getProductByName(String name){
        return  productRepository.findByName(name);
    }
    public ArrayList<ProductModel> getProducts(){
        return (ArrayList<ProductModel>) productRepository.findAll();
    }

    public ProductModel updateProductById(ProductModel request, long id) {
        Optional<ProductModel> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductModel product = optionalProduct.get();
            product.setName(request.getName());
            product.setBrand(request.getBrand());
            product.setCategory(request.getCategory());
            product.setPrice(request.getPrice());

            return productRepository.save(product); // Guardar el producto actualizado en la base de datos
        }
        return null;
    }

    public Boolean deleteProduct(long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
