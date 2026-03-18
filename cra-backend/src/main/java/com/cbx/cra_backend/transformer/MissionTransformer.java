package com.cbx.cra_backend.transformer;


import com.cbx.cra_backend.Utils.responses.MissionResponse;
import com.cbx.cra_backend.dto.MissionDto;
import com.cbx.cra_backend.entity.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionTransformer {

    // Dto en entity
    public Mission toEntity(MissionDto dto) {
        if (dto == null) {
            return null;
        }
        return Mission.builder()
                .titre(dto.getTitre())
                .dateDebut(dto.getDateDebut())
                .dateFin(dto.getDateFin())
                .description(dto.getDescription())
                .motif(dto.getMotif())
                .build();
    }

    // Entity en dto
    public MissionResponse toDto(Mission mission) {
        if (mission == null) {
            return null;
        }

        return MissionResponse.builder()
                .id(mission.getId())
                .titre(mission.getTitre())
                .dateDebut(mission.getDateDebut())
                .dateFin(mission.getDateFin())
                .description(mission.getDescription())
                .motif(mission.getMotif())
                .tjm(mission.getTjm())
                .build();
    }

}
