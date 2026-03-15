package Utils.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AssignmentResponse {

    private Long id;
    private Long collaboratorId;
    private UserResponses collaborateur;
    private Long missionId;
    private MissionResponse mission;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
