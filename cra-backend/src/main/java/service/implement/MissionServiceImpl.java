package service.implement;

import Utils.responses.MissionResponse;
import dto.MissionDto;
import entity.Mission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.MissionRepository;
import service.MissionService;
import transformer.MissionTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final MissionTransformer missionTransformer;

    @Override
    public MissionResponse create(MissionDto dto) {

        // caherence de date
        if(dto.getDateFin().isEqual(dto.getDateDebut())){
            throw  new IllegalArgumentException("la Date de fin est avant la Date de debut");
        }

        Mission mission = missionTransformer.toEntity(dto);
        mission = missionRepository.save(mission);

        return missionTransformer.toDto(mission);
    }

    @Override
    public List<MissionResponse> findAll() {
        //toute les missions
        return missionRepository.findAll().stream()
                .map(missionTransformer::toDto)
                .collect(Collectors.toList());    }

    @Override
    public MissionResponse getById(Long id) {

        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("la Mission est introuvable avec Id : " + id));
        return missionTransformer.toDto(mission);
    }
}
