package com.hanifomar.procurement_app.supplier.service.impl;

import com.hanifomar.procurement_app.supplier.dto.SupplierRequestDto;
import com.hanifomar.procurement_app.supplier.dto.SupplierResponseDto;
import com.hanifomar.procurement_app.supplier.mapper.SupplierMapper;
import com.hanifomar.procurement_app.supplier.model.Supplier;
import com.hanifomar.procurement_app.supplier.repository.SupplierRepository;
import com.hanifomar.procurement_app.supplier.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public List<SupplierResponseDto> getAllSuppliers() {
        return supplierMapper.toDtoList(supplierRepository.findAll());
    }

    @Override
    public SupplierResponseDto getSupplierById(UUID id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return supplierMapper.toDto(supplier);
    }

    @Override
    public SupplierResponseDto createSupplier(SupplierRequestDto requestDto) {
        Supplier supplier = supplierMapper.fromDto(requestDto);
        supplier.setCreatedAt(LocalDateTime.now());
        return supplierMapper.toDto(supplierRepository.save(supplier));
    }

    @Override
    public SupplierResponseDto updateSupplier(UUID id, SupplierRequestDto requestDto) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(requestDto.getName());
        supplier.setContactEmail(requestDto.getContactEmail());
        supplier.setPhone(requestDto.getPhone());
        supplier.setAddress(requestDto.getAddress());

        return supplierMapper.toDto(supplierRepository.save(supplier));
    }

    @Override
    public void deleteSupplier(UUID id) {
        supplierRepository.deleteById(id);

    }
}
