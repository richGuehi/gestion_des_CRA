package com.cbx.cra_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MissionDto {

    //pour les creation et motification

    @NotBlank(message = "Titre obligatoire")
    private String titre;

    @NotBlank(message = "dateDebut obligatoire")
    private LocalDate dateDebut;
    @NotBlank(message = "dateFin obligatoire")
    private LocalDate dateFin;
    private String description;
    private String motif;

    @NotBlank(message = "TJM est obligatoire")
    @Positive(message = "TJM doit etre positif")
    private BigDecimal tjm;

}
