package com.company.microservice3gateway.dto;

import com.google.gson.JsonElement;

public class CreateProductRequest  {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
