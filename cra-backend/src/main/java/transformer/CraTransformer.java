package transformer;

import Utils.enums.CraStatusEnum;
import Utils.responses.CraResponse;
import dto.CraDto;
import entity.Cra;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import repository.CraRepository;

@Component
@RequiredArgsConstructor
public class CraTransformer {

    private final UserTransformer userTransformer;

    public Cra toEntity(CraDto dto, User user) {
        if (dto == null){
            return null;
        }
        return Cra.builder()
                .collaborateur(user)
                .mois(dto.getMois())
                .annee(dto.getAnnee())
                .status(CraStatusEnum.DRAFT)
                .build();
    }

    public CraResponse toDto(Cra cra) {
        if (cra == null){
            return null;
        }

        return CraResponse.builder()
                .id(cra.getId())
                .callaborateur(userTransformer.toDto(cra.getCollaborateur()))
                .mois(cra.getMois())
                .annee(cra.getAnnee())
                .status(cra.getStatus().name())
                .motifRejet(cra.getMotifRejet())
                .build();
    }
}
