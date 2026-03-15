package dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {

    //pour les creation et motification

    @NotBlank(message = "Nom Obligatoire")
    private String nom;

    @NotBlank(message = "prenom Obligatoire")
    private String prenom;

    @NotBlank(message = "Email Obligatoire")
    @Email(message = "Email invalide")
    private String email;

    @NotBlank(message = "Password obligatoire")
    private String password;

    @NotBlank(message = "Rôle Obligatoire")
    private String role;

    private String status;
    private String contrat;
    private String seriorite;
    private String salaire;
}
