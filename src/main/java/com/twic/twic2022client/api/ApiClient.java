package com.twic.twic2022client.api;

import com.twic.twic2022client.Ville;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiClient {
    public static List<Ville> getVilles() throws IOException {
        URL url = new URL("http://localhost:8081/ville");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        return null;
    }
}
