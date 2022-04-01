package com.twic.twic2022client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ville {
    private Long id;
    private String codeCommuneINSEE;
    private String nomCommune;
    private String codePostal;
    private String libelleAcheminement;
    private String ligne5;
    private String latitude;
    private String longitude;
}
