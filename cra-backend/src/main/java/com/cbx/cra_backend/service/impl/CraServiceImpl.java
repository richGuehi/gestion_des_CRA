package com.cbx.cra_backend.service.impl;

import com.cbx.cra_backend.Utils.enums.CraStatusEnum;
import com.cbx.cra_backend.Utils.responses.CraResponse;
import com.cbx.cra_backend.dto.CraDto;
import com.cbx.cra_backend.entity.Cra;
import com.cbx.cra_backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cbx.cra_backend.repository.CraRepository;
import com.cbx.cra_backend.repository.UserRepository;
import com.cbx.cra_backend.service.CraService;
import com.cbx.cra_backend.transformer.CraTransformer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CraServiceImpl implements CraService {

    private final CraRepository craRepository;
    private final UserRepository userRepository;
    private final CraTransformer craTransformer;

    @Override
    public CraResponse createCra(CraDto dto) {
        if (craRepository.findByCollaborateurIdAndMoisAndAnnee(dto.getCollaborateurId(), dto.getMois(), dto.getAnnee()).isPresent()) {
            throw new RuntimeException("CRA existe pour le mois de cette année");
        }

        User collaborateur = userRepository.findById(dto.getCollaborateurId())
                .orElseThrow(() -> new RuntimeException("User introuvable"));

        Cra cra = craTransformer.toEntity(dto, collaborateur);
        cra =  craRepository.save(cra);

        return craTransformer.toDto(cra);
    }

    @Override
    public CraResponse getCraById(Long id) {
        Cra cra = craRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));
        return craTransformer.toDto(cra);
    }

    @Override
    public List<CraResponse> getCrasByCollaborateur(Long userId) {
        return craRepository.findAll().stream()
                .filter(cra -> cra.getCollaborateur().getId().equals(userId))
                .map(craTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CraResponse submitCra(Long id) {

        Cra cra = craRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        //ne plus modifié si il est deja validé
        if(cra.getStatus() == CraStatusEnum.APPROVED){
            throw new RuntimeException("CRA Deja validé par un ADMIN ne peut plus etre modiiié");
        }

        int jouActuel = LocalDate.now().getDayOfMonth();
        if (jouActuel < 22 || jouActuel > 28) {
            throw new RuntimeException("soumission du cra entre le 22 et le 28 du mois");
        }
        cra.setStatus(CraStatusEnum.SUBMITTED);
        cra = craRepository.save(cra);

        return craTransformer.toDto(cra);
    }

    @Override
    public CraResponse updateCra(Long id, String newStatus, String motifRejet) {

        Cra cra = craRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CRA introuvable"));

        CraStatusEnum nouveauStatut = CraStatusEnum.valueOf(newStatus.toUpperCase());

        if( nouveauStatut == CraStatusEnum.REJECTED || nouveauStatut == CraStatusEnum.INVALIDATED)
        {  if(motifRejet == null || motifRejet.isEmpty()){
                throw new RuntimeException("motif Obligatoire pour pour rejeter ou invalider le craa");
            }
        }

        cra.setStatus(nouveauStatut );

        if(nouveauStatut == CraStatusEnum.REJECTED || nouveauStatut == CraStatusEnum.INVALIDATED){

            cra.setMotifRejet(motifRejet);
        }else {
            cra.setMotifRejet(null);
        }


        cra = craRepository.save(cra);

        return craTransformer.toDto(cra);
    }
}
