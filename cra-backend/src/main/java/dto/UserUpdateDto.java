package dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserUpdateDto {
    //pour les creation et motification

    @NotBlank(message = "Nom Obligatoire")
    private String nom;

    @NotBlank(message = "prenom Obligatoire")
    private String prenom;

    @NotBlank(message = "Rôle Obligatoire")
    private String role;

    private String status;
    private String contrat;
    private String seriorite;
    private BigDecimal salaire;
}
