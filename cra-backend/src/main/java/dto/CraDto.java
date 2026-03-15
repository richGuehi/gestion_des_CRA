package dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CraDto {

    @NotNull(message = "Id collaborateur obligatoire")
    private Long collaborateurId;

    @Min(value = 1, message = "Mois compris entre 1 et 12 ")
    @Max(value = 12, message = "Mois compris entre 1 et 12 ")
    private int mois;

    @Min(value = 2020, message = "annee invalide")
    private int annee;

    private String status;
    private String motifRejet;
}
