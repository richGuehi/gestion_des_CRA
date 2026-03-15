package dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AssignmentDto {


    @NotNull(message = "Id Collaborateur(users) obligatoire")
    private Long collaborateurId;

    @NotNull(message = "Id Mission Obligatoire")
    private Long missionId;

    @NotNull(message = "Date debut Obligaoire" )
    private LocalDate datedebut;
    private LocalDate dateFin;

}
