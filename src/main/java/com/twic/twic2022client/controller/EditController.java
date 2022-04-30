package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import com.twic.twic2022client.api.Ville;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class EditController {

    @GetMapping("/edit")
    public String home(
            @RequestParam(value = "codeCommuneINSEE") String codeCommuneINSEE,
            Model model)
            throws IOException {
        Ville currentVille = ApiClient.getVille(codeCommuneINSEE);
        model.addAttribute("currentVille", currentVille);
        return "/edit";
    }

    @PostMapping("/edit")
    public String createVille(@ModelAttribute("currentVille") Ville ville) throws IOException {

        System.out.println(ville.getCodeCommuneINSEE());

        ApiClient.addVille(ville);
        return "/edit";
    }
}
