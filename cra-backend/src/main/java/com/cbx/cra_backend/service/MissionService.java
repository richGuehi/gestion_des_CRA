package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.MissionResponse;
import com.cbx.cra_backend.dto.MissionDto;

import java.util.List;

public interface MissionService {
    MissionResponse createMissions(MissionDto dto);

    List<MissionResponse> getAllMissions();
    MissionResponse getMissionById(Long id);

    MissionResponse updateMission(Long id, MissionDto dto);
    void deleteMissionById(Long id);

}
