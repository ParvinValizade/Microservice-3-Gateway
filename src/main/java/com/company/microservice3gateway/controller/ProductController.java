package com.company.microservice3gateway.controller;

import com.company.microservice3gateway.service.ProductService;
import com.google.gson.JsonElement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<JsonElement> createProduct(@RequestBody JsonElement product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<JsonElement>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
