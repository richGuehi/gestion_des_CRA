package com.cbx.cra_backend.service.impl;

import com.cbx.cra_backend.Utils.responses.MissionResponse;
import com.cbx.cra_backend.dto.MissionDto;
import com.cbx.cra_backend.entity.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cbx.cra_backend.repository.MissionRepository;
import com.cbx.cra_backend.service.MissionService;
import com.cbx.cra_backend.transformer.MissionTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final MissionTransformer missionTransformer;

    @Override
    public MissionResponse createMissions(MissionDto dto) {

        // caherence de date
        if(dto.getDateFin().isEqual(dto.getDateDebut())){
            throw  new IllegalArgumentException("la Date de fin est avant la Date de debut");
        }

        Mission mission = missionTransformer.toEntity(dto);
        mission = missionRepository.save(mission);

        return missionTransformer.toDto(mission);
    }

    @Override
    public List<MissionResponse> getAllMissions() {
        return missionRepository.findAll().stream()
                .map(m -> missionTransformer.toDto(m))
                .collect(Collectors.toList());
    }

    @Override
    public MissionResponse getMissionById(Long id) {
        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("mission introuvable"));
        return missionTransformer.toDto(mission);
    }

    @Override
    public MissionResponse updateMission(Long id, MissionDto dto) {

        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("mission introuvable"));

        if(dto.getDateFin().isBefore(dto.getDateDebut())){
            throw  new IllegalArgumentException("la Date de fin est avant la Date de debut");
        }

        mission.setTitre(dto.getTitre());
        mission.setDescription(dto.getDescription());
        mission.setDateDebut(dto.getDateDebut());
        mission.setDateFin(dto.getDateFin());
        mission.setMotif(dto.getMotif());
        mission.setTjm(dto.getTjm());

        mission = missionRepository.save(mission);

        return missionTransformer.toDto(mission);
    }

    //cahnger pour plus supprimer pour de vrai
    @Override
    public void deleteMissionById(Long id) {
        if(missionRepository.existsById(id)){
            throw  new RuntimeException("mission introuvable");
        }
        missionRepository.deleteById(id);
    }
}
