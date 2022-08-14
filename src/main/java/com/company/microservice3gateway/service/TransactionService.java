package com.company.microservice3gateway.service;

import com.company.microservice3gateway.request.TransactionServiceRequest;
import com.company.microservice3gateway.util.RetrofitUtils;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionServiceRequest transactionServiceRequest;

    public TransactionService(TransactionServiceRequest transactionServiceRequest) {
        this.transactionServiceRequest = transactionServiceRequest;
    }

    public JsonElement createTransaction(JsonElement transaction){
        return RetrofitUtils.executeInBlock(transactionServiceRequest.createTransaction(transaction));
    }

    public void deleteTransaction(Long transactionId){
        RetrofitUtils.executeInBlock(transactionServiceRequest.deleteTransaction(transactionId));
    }

    public List<JsonElement> getAllTransactionsOfUser(Long userId){
        return RetrofitUtils.executeInBlock(transactionServiceRequest.getAllTransactionsOfAuthorizedUser(userId));
    }
}
