package com.twic.twic2022client.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonarsource.scanner.api.internal.shaded.okhttp.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiClient {
    public static List<Ville> getVilles() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8081/villes")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper mapper = new ObjectMapper();
        List<Ville> villes;
        villes = mapper.readValue(response.body().string(), new TypeReference<List<Ville>>() {
        });
        return villes;
    }

    public static Ville getVille(String codeCommune) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8081/ville?codeCommuneINSEE=" + codeCommune)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body().string(), new TypeReference<Ville>() {
        });
    }

    public static Ville addVille(Ville ville) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{" +
                        "\"codeCommuneINSEE\":\"" + ville.getCodeCommuneINSEE() + "\"," +
                        "\r\n\"nomCommune\":\"" + ville.getNomCommune() + "\"," +
                        "\r\n\"codePostal\":\"" + ville.getCodePostal() + "\"," +
                        "\r\n\"libelleAcheminement\":\"" + ville.getLibelleAcheminement() + "\"," +
                        "\r\n\"ligne5\":\"" + ville.getLigne5() + "\"," +
                        "\r\n\"latitude\":\"" + ville.getLatitude() + "\"," +
                        "\r\n\"longitude\":\"" + ville.getLongitude() + "\"}"
                );
        System.out.print(body);
        Request request = new Request.Builder()
                .url("http://localhost:8081/ville")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return ville;
    }

    public static List<Ville> getVillesPage(Integer page) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8081/villes?page=" + page)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        ObjectMapper mapper = new ObjectMapper();
        List<Ville> villes;
        villes = mapper.readValue(response.body().string(), new TypeReference<List<Ville>>(){});
        return villes;
    }

    public static void modifierVille(
            String currentCodeCommune,
            String codeCommuneINSEE,
            String nomCommune,
            String codePostal,
            String libelleAcheminement,
            String ligne5,
            String latitude,
            String longitude
    ) throws IOException {
        URL url = new URL("http://localhost:8081/ville?"
                + "currentCodeCommune=" + currentCodeCommune
                + "&codeCommuneINSEE=" + codeCommuneINSEE
                + "&nomCommune=" + nomCommune
                + "&codePostal=" + codePostal
                + "&libelleAcheminement" + libelleAcheminement
                + "&ligne5" + ligne5
                + "&latitude" + latitude
                + "&longitude" + longitude

        );
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PATCH");
        int status = con.getResponseCode();
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        if (status >= 300) {
            reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
    }
}
