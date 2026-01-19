package com.hanifomar.procurement_app.purchaseorder.mapper;

import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PurchaseOrderMapper {

    @Mapping(target = "supplierName", source = "supplier.name")
    PurchaseOrderResponse toResponse(PurchaseOrder purchaseOrder);

}

