package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ListeController {

    @GetMapping("/liste")
    public String liste(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws IOException {
        model.addAttribute("villes", ApiClient.getVillesPage(page));
        model.addAttribute("page", page);
        return "liste";
    }
}
