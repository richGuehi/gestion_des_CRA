package com.cbx.cra_backend.Utils.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String token;
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
