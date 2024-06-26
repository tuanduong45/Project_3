package com.example.Project_3.sevice.supplier.impl;

import com.example.Project_3.constant.message.errorKey.ErrorKey;
import com.example.Project_3.constant.message.messageConst.MessageConst;
import com.example.Project_3.dtos.common.ICommonIdTaxCodeName;
import com.example.Project_3.dtos.supplier.IGetListSupplier;
import com.example.Project_3.dtos.supplier.SupplierCreateDTO;
import com.example.Project_3.entities.supplier.Supplier;
import com.example.Project_3.enums.supplier.SupplierStatusEnum;
import com.example.Project_3.exceptions.exceptionFactory.ExceptionFactory;
import com.example.Project_3.repositories.supplier.SupplierRepository;
import com.example.Project_3.sevice.supplier.SupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository ;
    @Autowired
    private ExceptionFactory exceptionFactory;
    @Override
    public void addSupplier(SupplierCreateDTO supplierCreateDTO) {
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierCreateDTO,supplier);
        supplier.setStatus(SupplierStatusEnum.NEW.getStatus());
        supplierRepository.save(supplier);
    }

    @Override
    public void updateSupplier(Long id, SupplierCreateDTO supplierCreateDTO) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isPresent()){
            BeanUtils.copyProperties(supplierCreateDTO,supplier.get());
            supplierRepository.save(supplier.get());
        }else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Supplier.NOT_FOUND_ERROR_CODE, MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.SUPPLIER,ErrorKey.Supplier.ID);
        }
    }

    @Override
    public void switchSupplierStatus(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if(supplier.isPresent()){
            supplierRepository.switchSupplierStatus(supplier.get().getId());
        } else {
            throw exceptionFactory.resourceNotFoundException(ErrorKey.Supplier.NOT_FOUND_ERROR_CODE,MessageConst.RESOURCE_NOT_FOUND,
                    MessageConst.Resources.SUPPLIER,ErrorKey.Supplier.ID);
        }
    }

    @Override
    public List<IGetListSupplier> getListSupplier(String name , String taxCode) {
        return supplierRepository.getListSupplier(name,taxCode);
    }

    @Override
    public List<ICommonIdTaxCodeName> getListSupplierIdTaxCodeName() {
        return supplierRepository.getListSupplierIdTaxCodeName();
    }


}
