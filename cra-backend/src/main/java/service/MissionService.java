package service;

import Utils.responses.MissionResponse;
import dto.MissionDto;
import entity.Mission;

import java.util.List;

public interface MissionService {
    MissionResponse create(MissionDto dto);
    List<MissionResponse> findAll();
    MissionResponse getById(Long id);

}
