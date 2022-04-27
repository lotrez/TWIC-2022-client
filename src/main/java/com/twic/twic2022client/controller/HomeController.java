package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import com.twic.twic2022client.api.Ville;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) throws IOException, JSONException {
        List<Ville> villes = ApiClient.getVilles();
        for (Ville ville: villes) {
            System.out.println(ville.getNomCommune());
        }
        model.addAttribute("villes", villes);
        return "/home";
    }

}
