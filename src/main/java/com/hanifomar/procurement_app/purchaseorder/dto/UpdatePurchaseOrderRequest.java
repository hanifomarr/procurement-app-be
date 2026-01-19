package com.hanifomar.procurement_app.purchaseorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePurchaseOrderRequest {
    private UUID supplierId;
    private List<PurchaseOrderItemRequest> items;
}
