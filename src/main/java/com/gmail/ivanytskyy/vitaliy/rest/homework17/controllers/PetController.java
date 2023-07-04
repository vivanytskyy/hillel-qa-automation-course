package com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Pet;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 02/07/2023
 */
public class PetController {
    private final OkHttpClient client;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet";

    public PetController(){
        this.client = new OkHttpClient();
    }
    public Pet addPet(Pet pet) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(pet), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Pet.class);
        }
    }
    public Pet updatePet(Pet pet) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(pet), JSON);
        Request request = new Request.Builder()
                .url(BASE_URL)
                .put(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Pet.class);
        }
    }
    public Pet[] findPetsByStatus(PetStatus status) throws IOException {
        String queryString = String.format("/findByStatus?status=%s", status.toString().toLowerCase());
        Request request = new Request.Builder()
                .url(BASE_URL + queryString)
                .get()
                .build();
        Gson gson = new Gson();
        try(Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Pet[].class);
        }
    }
    public Pet findPetById(Long id) throws IOException {
        String addToPathString = String.format("/%s", id);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .get()
                .build();
        Gson gson = new Gson();
        try(Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return gson.fromJson(response.body().string(), Pet.class);
        }
    }
    public int updatePetById(Long id, String petName, PetStatus status ) throws IOException {
        String addToPathString = String.format("/%s", id);
        FormBody formBody = new FormBody(
                List.of("name", "status"),
                List.of(petName, status.toString().toLowerCase()));
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .post(formBody)
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public int uploadImageById(Long id, String additionalMetadata, File file ) throws IOException {
        String addToPathString = String.format("/%s/uploadImage", id);
        RequestBody formBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getAbsolutePath(),
                        RequestBody.create(file, MediaType.parse("image/png")))
                .addFormDataPart("additionalMetadata", additionalMetadata)
                .build();
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .post(formBody)
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public int deletePetById(Long id, String apiKey) throws IOException {
        String addToPathString = String.format("/%s", id);
        Request request = new Request.Builder()
                .url(BASE_URL + addToPathString)
                .addHeader("api_key", apiKey)
                .delete()
                .build();
        try(Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
    public enum PetStatus{
        AVAILABLE, PENDING, SOLD
    }
}