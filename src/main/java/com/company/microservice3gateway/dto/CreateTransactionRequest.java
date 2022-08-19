package com.company.microservice3gateway.dto;

public class CreateTransactionRequest {
    private Long userId;
    private Long productId;

    public Long getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }
}
