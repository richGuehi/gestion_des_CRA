package com.cbx.cra_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CraDayDto {
    private Long id;
    @NotNull(message = "Id du cra obligatoire")
    private Long craId;

    @NotNull(message = "date obligatoire")
    private LocalDate date;

    @NotBlank(message = "Type d'activité obligatoire ")
    private String typeActivite;
}
