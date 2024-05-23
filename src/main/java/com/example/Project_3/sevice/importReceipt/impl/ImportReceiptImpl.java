package com.example.Project_3.sevice.importReceipt.impl;

import com.example.Project_3.dtos.importReceipt.*;
import com.example.Project_3.dtos.importReceiptDetail.IGetListImportReceiptDetail;
import com.example.Project_3.dtos.importReceiptDetail.ImportReceiptDetailLstDTO;
import com.example.Project_3.entities.drug.DrugImportReceipt;
import com.example.Project_3.entities.importReceipt.ImportReceipt;
import com.example.Project_3.entities.users.User;
import com.example.Project_3.enums.importReceiptStatus.ImportReceiptStatus;
import com.example.Project_3.repositories.importReceipt.drugImportReceipt.DrugImportReRepo;
import com.example.Project_3.repositories.importReceipt.ImportReceiptRepository;
import com.example.Project_3.repositories.supplier.SupplierRepository;
import com.example.Project_3.repositories.user.UserRepository;
import com.example.Project_3.sevice.importReceipt.ImportReceiptService;
import com.example.Project_3.utils.auth.AuthUtils;
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
    private UserRepository userRepository;
    @Autowired
    private SupplierRepository supplierRepository;



    @Override
    public void createImportReceipt(ImportReceiptDTO importReceiptDTO) {
        ImportReceipt importReceipt = new ImportReceipt();
        importReceipt.setImportDate(new Date());
        importReceipt.setImportReceiptCode(generateUserCode());
        importReceipt.setStatus(ImportReceiptStatus.IMPORTED.getValue());
        Long userId = AuthUtils.getCurrentUserId();
        Optional<User> user = userRepository.findById(userId);
        importReceipt.setUser(user.get());
        Long importReceiptID = importReceiptRepository.save(importReceipt).getId();
        List<DrugImportReceipt> drugImportReceipts = importReceiptDTO.getImportReceiDetailDTOS().stream().map(
                value->new DrugImportReceipt(importReceiptID, value.getDrugId(), value.getQuantity(),
                        value.getUnitId(), value.getPrice(), value.getExpiryDate(), value.getProduceBatchNumber(),
                        supplierRepository.findById(value.getSupplierId()).get(), value.getPrice() * value.getQuantity())
        ).toList();
        drugImportReRepo.saveAll(drugImportReceipts);

    }

   /* @Override
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

    */

    @Override
    public List<IGetLstImportReceipt> getLstImportReceipt(String code, Date startDate, Date endDate) {
        return importReceiptRepository.getLstImportReceipt(code,startDate,endDate);
    }

    @Override
    public List<Map<ImportReceiptListDTO, List<IGetListImportReceiptDetail>>> getLstImportReceiptAll(String code, Date startDate, Date endDate) {
        List<Map<ImportReceiptListDTO,List<IGetListImportReceiptDetail>>> mapList = new ArrayList<>();
        Map<ImportReceiptListDTO,List<IGetListImportReceiptDetail>> map = new HashMap<>();
        for(IGetLstImportReceipt importReceipt : getLstImportReceipt(code,startDate,endDate)){
            ImportReceiptListDTO importReceiptListDTO = new ImportReceiptListDTO();
            BeanUtils.copyProperties(importReceipt,importReceiptListDTO);
            List<IGetListImportReceiptDetail>  list = getListImportReceiptDetail(importReceipt.getId());
            map.put(importReceiptListDTO,list);
        }
        mapList.add(map);
        return mapList;
    }

    @Override
    public List<IGetListImportReceiptDetail> getListImportReceiptDetail(Long id) {
        return importReceiptRepository.getLstImportReceiptDetail(id);
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
