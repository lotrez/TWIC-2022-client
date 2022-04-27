package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import com.twic.twic2022client.api.Ville;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() throws IOException, JSONException {
        List<Ville> villes = ApiClient.getVilles();
        System.out.println(villes.size());
        return "/home";
    }

}
