package com.hanifomar.procurement_app.purchaseorder.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePurchaseOrderRequest {

    @NotNull(message = "Supplier is required")
    private UUID supplierId;

    @NotNull(message = "Staff is required")
    private UUID createdBy;

    private List<PurchaseOrderItemRequest> items;
}
