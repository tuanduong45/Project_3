package com.example.Project_3.sevice.supplier;

import com.example.Project_3.dtos.supplier.SupplierCreateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    void addSupplier(SupplierCreateDTO supplierCreateDTO);
    void updateSupplier(Long id ,SupplierCreateDTO supplierCreateDTO);

    void deleteSupplier(Long id );

    List<SupplierCreateDTO> getListSupplier();
}
