package com.cbx.cra_backend.service.impl;

import com.cbx.cra_backend.Utils.enums.ActivityType;
import com.cbx.cra_backend.Utils.enums.CraStatusEnum;
import com.cbx.cra_backend.Utils.responses.CraDayResponse;
import com.cbx.cra_backend.dto.CraDayDto;
import com.cbx.cra_backend.entity.Cra;
import com.cbx.cra_backend.entity.CraDay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cbx.cra_backend.repository.CraDayRepository;
import com.cbx.cra_backend.repository.CraRepository;
import com.cbx.cra_backend.service.CraDayService;
import com.cbx.cra_backend.transformer.CraDayTransformer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CraDayServiceImpl implements CraDayService {

    private final CraDayRepository craDayRepository;
    private final CraRepository craRepository;
    private final CraDayTransformer craDayTransformer;

    @Override
    public CraDayResponse saveDay(CraDayDto dto) {
        Cra cra = craRepository.findById(dto.getCraId())
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        // peut pas modifier si il est deja validé

        if(cra.getStatus() == CraStatusEnum.APPROVED){
            throw new RuntimeException("impossible de modifier days sur cra deja validé");
        }

        CraDay craDay = craDayTransformer.toEntity(dto, cra);
        craDay = craDayRepository.save(craDay);
        return craDayTransformer.toDto(craDay);
    }

    @Override
    public List<CraDayResponse> autoFillCra(Long craId) {

        Cra cra = craRepository.findById(craId)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        if(cra.getStatus() == CraStatusEnum.APPROVED){
            throw new RuntimeException("Impossible de modifier un CRA deja validé");
        }

        YearMonth ym = YearMonth.of(cra.getAnnee(), cra.getMois());
        int daysInMonth = ym.lengthOfMonth();

        List<CraDay> jourCrees = new ArrayList<>();

        for(int i = 0; i < daysInMonth; i++){
            LocalDate currentDate = ym.atDay(i);

            if(currentDate.getDayOfWeek() == DayOfWeek.SATURDAY
                && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY ){

                CraDay craDay = CraDay.builder()
                        .cra(cra)
                        .date(currentDate)
                        .typeActivite(ActivityType.TRAVAILLE)
                        .build();
                jourCrees.add(craDay);
            }
        }

        List<CraDay> savedDays = craDayRepository.saveAll(jourCrees);
        return savedDays.stream()
                .map(craDayTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CraDayResponse> getAllDaysForCra(Long craId) {
        return craDayRepository.findByCraId(craId).stream()
                .map(craDayTransformer::toDto)
                .collect(Collectors.toList());
    }
}
