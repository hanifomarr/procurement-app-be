package com.hanifomar.procurement_app.supplier.mapper;

import com.hanifomar.procurement_app.supplier.dto.SupplierRequestDto;
import com.hanifomar.procurement_app.supplier.dto.SupplierResponseDto;
import com.hanifomar.procurement_app.supplier.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplierMapper {

    List<SupplierResponseDto> toDtoList(List<Supplier> suppliers);

    SupplierResponseDto toDto(Supplier supplier);

    Supplier fromDto(SupplierRequestDto dto);

}
