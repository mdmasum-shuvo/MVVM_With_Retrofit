package com.example.mvvm_with_retrofit.api;

public class ApiUtils {

    private static final String BASE_URL = "https://api.github.com/";

    private ApiUtils() {
    }

    public static ApiService getService() {

        return ApiClient.getClient(BASE_URL).create(ApiService.class);
    }
}
