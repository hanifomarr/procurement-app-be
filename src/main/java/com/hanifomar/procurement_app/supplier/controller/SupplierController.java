package com.hanifomar.procurement_app.supplier.controller;

import com.hanifomar.procurement_app.supplier.dto.SupplierRequestDto;
import com.hanifomar.procurement_app.supplier.dto.SupplierResponseDto;
import com.hanifomar.procurement_app.supplier.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(@PathVariable UUID id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @PostMapping
    public ResponseEntity<SupplierResponseDto> createSupplier(@Valid @RequestBody SupplierRequestDto supplierRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(supplierService.createSupplier(supplierRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> updateSupplier(
            @PathVariable UUID id,
            @Valid @RequestBody SupplierRequestDto supplierRequestDto
    ) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable UUID id) {
        supplierService.deleteSupplier(id);

        return ResponseEntity.noContent().build();
    }

}
