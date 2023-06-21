package com.api.crud.products.controllers;

import com.api.crud.products.models.ProductModel;
import com.api.crud.products.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/{name}")
    public List<ProductModel> getProductByName(@PathVariable String name){
        return this.productService.getProductByName(name);
    }
    @GetMapping
    public ArrayList<ProductModel> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel product){
        return this.productService.saveProduct(product);

    }
    @PutMapping("/{id}")
    public ProductModel updateProductById(@RequestBody ProductModel request, @PathVariable("id") long id) {
        return productService.updateProductById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        boolean ok = productService.deleteProduct(id);
        if (ok) {
            return "Producto " + id + " eliminado.";
        } else {
            return "Error al eliminar";
        }
    }

}
