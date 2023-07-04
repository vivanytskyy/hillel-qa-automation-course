package com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.User;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 04/07/2023
 */
public class UserController {
    private final OkHttpClient client;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final String BASE_URL = "https://petstore.swagger.io/v2/user";
    public UserController(){
        client = new OkHttpClient();
    }
    public int createUser(User user) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(user), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.code();
        }
    }
    public int createUsersWithArray(User[] users) throws IOException {
        String addToPathString = "/createWithArray";
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(users), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.code();
        }
    }
    public int createUsersWithList(List<User> users) throws IOException {
        String addToPathString = "/createWithList";
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(users), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .post(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.code();
        }
    }
    public User getUserByUsername(String username) throws IOException {
        String addToPathString = String.format("/%s", username);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .get()
                .build();
        Gson gson = new Gson();
        try(Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), User.class);
        }
    }
    public int updateUserByUsername(String username, User userForUpdate) throws IOException {
        String addToPathString = String.format("/%s", username);
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(userForUpdate), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .put(body)
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.code();
        }
    }
    public int deleteUserByUsername(String username) throws IOException {
        String addToPathString = String.format("/%s", username);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute()){
            return response.code();
        }
    }
    public int login(String username, String password) throws IOException {
        String queryString = String.format("/login?username=%s&password=%s", username, password);
        Request request = new Request.Builder()
                .url(BASE_URL + queryString)
                .get()
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public int logout() throws IOException {
        String addToPathString = "/logout";
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .get()
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
}