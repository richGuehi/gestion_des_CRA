package com.cbx.cra_backend.transformer;

import com.cbx.cra_backend.Utils.enums.ActivityType;
import com.cbx.cra_backend.Utils.responses.CraDayResponse;
import com.cbx.cra_backend.dto.CraDayDto;
import com.cbx.cra_backend.entity.Cra;
import com.cbx.cra_backend.entity.CraDay;
import org.springframework.stereotype.Component;

@Component
public class CraDayTransformer {

    public CraDay toEntity(CraDayDto dto, Cra cra) {
        if (cra == null) {
            return null;
        }

        return CraDay.builder()
                .cra(cra)
                .date(dto.getDate())
                .typeActivite(ActivityType.valueOf(dto.getTypeActivite().toUpperCase()))
                .build();
    }

    public CraDayResponse toDto(CraDay craDay) {
        if (craDay == null) {
            return null;
        }

        return CraDayResponse.builder()
                .id(craDay.getId())
                .craId(craDay.getCra().getId())
                .date(craDay.getDate())
                .typeActivite(craDay.getTypeActivite().name())
                .build();
    }
}
