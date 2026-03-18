package com.cbx.cra_backend.Utils.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CraResponse {
    private Long id;
    private Long collaborateurId;
    private UserResponses callaborateur;
    private int mois;
    private int annee;
    private String status;
    private String motifRejet;
}
