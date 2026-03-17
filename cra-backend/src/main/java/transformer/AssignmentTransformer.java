package transformer;

import Utils.responses.AssignmentResponse;
import dto.AssignmentDto;
import entity.Assignment;
import entity.Mission;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AssignmentTransformer {
    private final MissionTransformer missionTransformer;
    private final UserTransformer userTransformer;

    public Assignment toEntity(AssignmentDto dto, User user, Mission mission){

        if (dto == null){
            return null;
        }

        return Assignment.builder()
                .collaborateur(user)
                .mission(mission)
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .build();
    }

    public AssignmentResponse toDto(Assignment assignment){
        if (assignment == null){
            return null;
        }

        return AssignmentResponse.builder()
                .id(assignment.getId())
                .collaborateur(userTransformer.toDto(assignment.getCollaborateur()))
                .mission(missionTransformer.toDto(assignment.getMission()))
                .dateDebut(assignment.getDateDebut())
                .dateFin(assignment.getDateFin())
                .build();
    }
}
