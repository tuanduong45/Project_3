package com.example.Project_3.sevice.inventory.drugWarningImpl;

import com.example.Project_3.dtos.inventory.DrugWarningDTO;
import com.example.Project_3.dtos.inventory.DrugWarningListDTO;
import com.example.Project_3.entities.inventory.DrugWarning;
import com.example.Project_3.repositories.inventory.DrugWarningRepository;
import com.example.Project_3.sevice.inventory.DrugWarningService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrugWarningServiceImpl implements DrugWarningService {

    @Autowired
    private DrugWarningRepository drugWarningRepository;

    @Override
    public void addDrugWarning(DrugWarningListDTO drugWarningListDTO) {

        if(!drugWarningRepository.existsByDrugId(drugWarningListDTO.getDrugId())){
         List<DrugWarning> drugWarningList = drugWarningListDTO.getDrugWarningDTOS()
                 .stream()
                 .map(drugWarningDTO -> new DrugWarning(drugWarningListDTO.getDrugId()
                         , drugWarningDTO.getProduceBatchNumber(), drugWarningDTO.getExpiryBeforeDay()))
                 .toList();
         drugWarningRepository.saveAll(drugWarningList);
        } else  {
            for(DrugWarningDTO dto : drugWarningListDTO.getDrugWarningDTOS()){
               if(drugWarningRepository.existsByProduceBatchNumber(dto.getProduceBatchNumber())) {
                   DrugWarning drugWarning = drugWarningRepository.findByProduceBatchNumber(dto.getProduceBatchNumber());
                   drugWarning.setExpiryBeforeDay(dto.getExpiryBeforeDay());
                   drugWarningRepository.save(drugWarning);
               } else  {
                   DrugWarning drugWarning = new DrugWarning();
                   drugWarning.setDrugId(drugWarningListDTO.getDrugId());
                   drugWarning.setProduceBatchNumber(dto.getProduceBatchNumber());
                   drugWarning.setExpiryBeforeDay(dto.getExpiryBeforeDay());
                   drugWarningRepository.save(drugWarning);
               }
            }
        }




    }
}
