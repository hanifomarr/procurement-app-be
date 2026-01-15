package com.hanifomar.procurement_app.supplier.service;

import com.hanifomar.procurement_app.supplier.dto.SupplierRequestDto;
import com.hanifomar.procurement_app.supplier.dto.SupplierResponseDto;
import com.hanifomar.procurement_app.supplier.model.Supplier;

import java.util.List;
import java.util.UUID;

public interface SupplierService {
    List<SupplierResponseDto> getAllSuppliers();

    SupplierResponseDto getSupplierById(UUID id);

    SupplierResponseDto createSupplier(SupplierRequestDto requestDto);

    SupplierResponseDto updateSupplier(UUID id, SupplierRequestDto requestDto);

    void deleteSupplier(UUID id);

}
