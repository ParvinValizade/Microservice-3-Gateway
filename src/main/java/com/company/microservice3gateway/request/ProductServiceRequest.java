package com.company.microservice3gateway.request;

import com.company.microservice3gateway.dto.CreateProductRequest;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ProductServiceRequest {

    @POST("/api/product")
    Call<JsonElement> createProduct(@Body CreateProductRequest requestBody);

    @DELETE("/api/product/{productId}")
    Call<Void> deleteProduct(@Path("productId") Long productId);

    @GET("/api/product")
    Call<List<JsonElement>> getAllProducts();
}
