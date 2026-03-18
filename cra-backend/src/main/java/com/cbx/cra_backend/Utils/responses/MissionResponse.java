package com.cbx.cra_backend.Utils.responses;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class MissionResponse {

    private Long id;
    private String titre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    private String motif;
    private BigDecimal tjm;
}
