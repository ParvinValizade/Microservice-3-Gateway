package com.company.microservice3gateway.controller;

import com.company.microservice3gateway.dto.CreateTransactionRequest;
import com.company.microservice3gateway.security.UserPrincipal;
import com.company.microservice3gateway.service.TransactionService;
import com.google.gson.JsonElement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @Operation(summary = "Create Transaction", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<JsonElement> createTransaction(@RequestBody CreateTransactionRequest transaction){
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @DeleteMapping("{transactionId}")
    @Operation(summary = "Delete Transaction", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long transactionId){
        transactionService.deleteTransaction(transactionId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "GetAllTransactionsOfAuthorizedUser", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<List<JsonElement>> getAllTransactionsOfAuthorizedUser(
            @AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.ok(transactionService.getAllTransactionsOfUser(principal.getId()));
    }
}
