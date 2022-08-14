package com.company.microservice3gateway.service;

import com.company.microservice3gateway.request.ProductServiceRequest;
import com.company.microservice3gateway.util.RetrofitUtils;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductServiceRequest productServiceRequest;

    public ProductService(ProductServiceRequest productServiceRequest) {
        this.productServiceRequest = productServiceRequest;
    }

    public JsonElement createProduct(JsonElement requestBody){
        return RetrofitUtils.executeInBlock(productServiceRequest.createProduct(requestBody));
    }

    public void deleteProduct(Long productId){
        RetrofitUtils.executeInBlock(productServiceRequest.deleteProduct(productId));
    }

    public List<JsonElement> getAllProducts(){
        return RetrofitUtils.executeInBlock(productServiceRequest.getAllProducts());
    }
}
