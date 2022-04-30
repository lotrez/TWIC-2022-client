package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import com.twic.twic2022client.api.Ville;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String editVille(@ModelAttribute("currentVille") Ville ville) throws IOException {

        // Identifiant unique en BDD oblige
        String[] code = ville.getCodeCommuneINSEE().split(",");
        ville.setCodeCommuneINSEE(code[code.length-1]);

        ApiClient.editVille(ville);
        return "/edit";
    }

    @DeleteMapping("/delete")
    public void deleteVille(
            @RequestParam(value = "codeCommuneINSEE") String codeCommuneINSEE
    ) throws IOException {
        System.out.println("DELETE");

        ApiClient.deleteVille(codeCommuneINSEE);
    }
}
