package com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Order;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/07/2023
 */
public class StoreController {
    private final OkHttpClient client;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final String BASE_URL = "https://petstore.swagger.io/v2/store";

    public StoreController() {
        this.client = new OkHttpClient();
    }
    public Order placeOrderForPet(Order order) throws IOException {
        String addToPathString = "/order";
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(order), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Order.class);
        }
    }
    public Order findPurchaseOrderById(Long id) throws IOException {
        String addToPathString = String.format("/order/%s", id);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .get()
                .build();
        Gson gson = new Gson();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Order.class);
        }
    }
    public int deletePurchaseOrderById(Long id) throws IOException {
        String addToPathString = String.format("/order/%s", id);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public int returnPetInventoriesByStatus() throws IOException {
        String addToPathString = "/inventory";
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .get()
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public enum OrderStatus{
        PLACED, APPROVED, DELIVERED
    }
}