package com.twic.twic2022client.controller;

import com.twic.twic2022client.api.ApiClient;
import com.twic.twic2022client.api.Ville;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String patch(
            @RequestParam(value = "currentCodeCommune") String currentCodeCommune,
            @RequestParam(required = false, value = "codeCommuneINSEE") String codeCommuneINSEE,
            @RequestParam(required = false, value = "nomCommune") String nomCommune,
            @RequestParam(required = false, value = "codePostal") String codePostal,
            @RequestParam(required = false, value = "libelleAcheminement") String libelleAcheminement,
            @RequestParam(required = false, value = "ligne5") String ligne5,
            @RequestParam(required = false, value = "latitude") String latitude,
            @RequestParam(required = false, value = "longitude") String longitude
    ) throws IOException {
        System.out.print("PATCH");
        ApiClient.modifierVille(
                currentCodeCommune,
                codeCommuneINSEE,
                nomCommune,
                codePostal,
                libelleAcheminement,
                ligne5,
                latitude,
                longitude
        );
        return "/edit";
    }
}
