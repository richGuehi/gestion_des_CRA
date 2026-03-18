package com.cbx.cra_backend.Utils.responses;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserResponses {

    // pour les reponses du backend

    private Long id;;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String statut;
    private String contrat;
    private String seriorite;
    private BigDecimal salaire;
    private Boolean active;
}
