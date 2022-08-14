package com.company.microservice3gateway.util;

import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class RetrofitUtils {
    public static <T> T executeInBlock(Call<T> request){

        try {
            Response<T> response = request.execute();

            if (!response.isSuccessful()){
                System.err.println("Request completed unsuccessfully with statusCode: {"+response.code()+"} and " +
                        "reason:{"+response.errorBody().string()+"}");
            }
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }
}
