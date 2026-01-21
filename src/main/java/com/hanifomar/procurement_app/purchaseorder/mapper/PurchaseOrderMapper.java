package com.hanifomar.procurement_app.purchaseorder.mapper;

import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderItemResponse;
import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PurchaseOrderMapper {

    @Mapping(target = "supplierName", source = "supplier.name")
    @Mapping(target = "supplierId", source = "supplier.id")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "items", source = "purchaseOrderItemList")
    @Mapping(target = "totalQuantity", expression = "java(po.getTotalQuantity())")
    PurchaseOrderResponse toResponse(PurchaseOrder po);

    List<PurchaseOrderResponse> toResponseList(List<PurchaseOrder> orders);

    @Mapping(target = "lineTotal", expression = "java(item.getLineTotal())")
    PurchaseOrderItemResponse toItemResponse(PurchaseOrderItem item);

}

