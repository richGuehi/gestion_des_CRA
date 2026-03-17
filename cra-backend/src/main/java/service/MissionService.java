package service;

import Utils.responses.MissionResponse;
import dto.MissionDto;
import entity.Mission;

import java.util.List;

public interface MissionService {
    MissionResponse createMissions(MissionDto dto);

    List<MissionResponse> getAllMissions();
    MissionResponse getMissionById(Long id);

    MissionResponse updateMission(Long id, MissionDto dto);
    void deleteMissionById(Long id);

}
