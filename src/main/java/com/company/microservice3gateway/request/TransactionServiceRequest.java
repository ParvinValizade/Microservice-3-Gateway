package com.company.microservice3gateway.request;

import com.company.microservice3gateway.dto.CreateTransactionRequest;
import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface TransactionServiceRequest {

    @POST("/api/transaction")
    Call<JsonElement> createTransaction(@Body CreateTransactionRequest requestBody);

    @DELETE("/api/transaction/{transactionId}")
    Call<Void> deleteTransaction(@Path("transactionId") Long transactionId);

    @GET("/api/transaction/{userId}")
    Call<List<JsonElement>> getAllTransactionsOfAuthorizedUser(@Path("userId") Long userId);
}
