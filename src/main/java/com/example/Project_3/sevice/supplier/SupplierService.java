package com.example.Project_3.sevice.supplier;

import com.example.Project_3.dtos.common.ICommonIdTaxCodeName;
import com.example.Project_3.dtos.supplier.IGetListSupplier;
import com.example.Project_3.dtos.supplier.SupplierCreateDTO;
import com.example.Project_3.entities.supplier.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    void addSupplier(SupplierCreateDTO supplierCreateDTO);
    void updateSupplier(Long id ,SupplierCreateDTO supplierCreateDTO);

    void switchSupplierStatus(Long id );

    List<IGetListSupplier> getListSupplier(String name , String taxCode);

    List<ICommonIdTaxCodeName> getListSupplierIdTaxCodeName();
}
