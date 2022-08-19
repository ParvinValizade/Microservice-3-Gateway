package com.company.microservice3gateway.controller;

import com.company.microservice3gateway.dto.CreateProductRequest;
import com.company.microservice3gateway.service.ProductService;
import com.google.gson.JsonElement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "Create Product", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<JsonElement> createProduct(@RequestBody CreateProductRequest product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @DeleteMapping("{productId}")
    @Operation(summary = "Delete Product", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "GetAllProduct", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<JsonElement>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
