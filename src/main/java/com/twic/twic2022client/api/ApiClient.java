package com.twic.twic2022client.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApiClient {
    public static List<Ville> getVilles() throws IOException {
        URL url = new URL("http://localhost:8081/villes");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
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
        }
        else {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
//        System.out.println("response code: " + status);
//        System.out.println("response string: " + responseContent.toString());
        ObjectMapper mapper = new ObjectMapper();
        List<Ville> villes;
        villes = mapper.readValue(responseContent.toString(), new TypeReference<List<Ville>>(){});
        return villes;
    }

    public static Ville getVille(String codeCommune) throws IOException {
        URL url = new URL("http://localhost:8081/ville?codeCommuneINSEE=" + codeCommune);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
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
        }
        else {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
//        System.out.println("response code: " + status);
//        System.out.println("response string: " + responseContent.toString());
        ObjectMapper mapper = new ObjectMapper();
        Ville ville;
        ville = mapper.readValue(responseContent.toString(), new TypeReference<Ville>(){});
        return ville;
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
        }
        else {
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
        }
    }
}
