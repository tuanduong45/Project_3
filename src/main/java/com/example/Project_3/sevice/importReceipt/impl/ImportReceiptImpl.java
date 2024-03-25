package com.example.Project_3.sevice.importReceipt.impl;

import com.example.Project_3.dtos.importReceipt.IGetListImportReceipt;
import com.example.Project_3.dtos.importReceipt.IGetLstImportReceiptALL;
import com.example.Project_3.dtos.importReceipt.ImportReceiptDTO;
import com.example.Project_3.dtos.importReceipt.ImportReceiptListDTO;
import com.example.Project_3.dtos.importReceiptDetail.ImportReceiptDetailLstDTO;
import com.example.Project_3.entities.drug.DrugImportReceipt;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import com.example.Project_3.enums.importReceiptStatus.ImportReceiptStatus;
import com.example.Project_3.repositories.drugImportReceipt.DrugImportReRepo;
import com.example.Project_3.repositories.importReceipt.ImportReceiptRepository;
import com.example.Project_3.repositories.supplier.SupplierRepository;
import com.example.Project_3.sevice.importReceipt.ImportReceiptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImportReceiptImpl implements ImportReceiptService {
    @Autowired
    private ImportReceiptRepository importReceiptRepository;
    @Autowired
    private DrugImportReRepo drugImportReRepo ;

    @Autowired
    private SupplierRepository supplierRepository;



    @Override
    public void createImportReceipt(ImportReceiptDTO importReceiptDTO) {
        ImportReceipt importReceipt = new ImportReceipt();
        importReceipt.setImportDate(new Date());
        importReceipt.setImportReceiptCode(generateUserCode());
        importReceipt.setStatus(ImportReceiptStatus.CONFIRMING.getName());
        importReceipt.setImportPersonName("admin");
        Long importReceiptID = importReceiptRepository.save(importReceipt).getId();
        List<DrugImportReceipt> drugImportReceipts = importReceiptDTO.getImportReceiDetailDTOS().stream().map(
                value->new DrugImportReceipt(importReceiptID, value.getDrugId(), value.getQuantity(),
                        value.getUnitId(), value.getPrice(), value.getExpiryDate(), value.getProduceBatchNumber(),
                        supplierRepository.findById(value.getSupplierId()).get(), value.getPrice() * value.getQuantity())
        ).toList();
        drugImportReRepo.saveAll(drugImportReceipts);

    }

    @Override
    public List<Map<ImportReceiptListDTO, List<ImportReceiptDetailLstDTO>>> getListImportReceipt(String code, Date date ,String status) {
        List<Map<ImportReceiptListDTO,List<ImportReceiptDetailLstDTO>>> mapList = new ArrayList<>();
        List<IGetLstImportReceiptALL> lstImportReceipts = importReceiptRepository.getListImportReceipt(code,date,status);
        List<IGetListImportReceipt> stringList = importReceiptRepository.getListImportReceiptByCode();
        for(IGetListImportReceipt codeImport : stringList){
            Map<ImportReceiptListDTO,List<ImportReceiptDetailLstDTO>> map = new HashMap<>();
            List<ImportReceiptDetailLstDTO> list = new ArrayList<>();
            ImportReceiptListDTO importReceiptListDTO = new ImportReceiptListDTO();
            BeanUtils.copyProperties(codeImport,importReceiptListDTO);
            for(IGetLstImportReceiptALL importReceipt : lstImportReceipts){
                if(importReceipt.getImportReceiptCode().equals(codeImport.getImportReceiptCode())){
                    ImportReceiptDetailLstDTO detailLstDTO = new ImportReceiptDetailLstDTO();
                    BeanUtils.copyProperties(importReceipt,detailLstDTO);
                    list.add(detailLstDTO);
                }

            }
            map.put(importReceiptListDTO,list);
            mapList.add(map);
        }
        return  mapList;
    }




    public String generateUserCode() {
        String baseCode = "PNK";
        Random random = new Random();
        String generatedCode = baseCode + (random.nextInt(100000) + 100000);
        while (importReceiptRepository.existsByImportReceiptCode(generatedCode)){
            generatedCode = baseCode + (random.nextInt(100000) + 100000);
        }
        return generatedCode;

    }

}
