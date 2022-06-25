package com.example.app_mobile.Service;

public class APIService {
    private static String base_url ="http://192.168.1.5:3000/";

    public static Dataservice getService() {
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
