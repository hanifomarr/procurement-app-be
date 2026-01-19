package com.hanifomar.procurement_app.purchaseorder.dto;

import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderResponse {
    private UUID id;
    private String poNumber;
    private PurchaseOrderStatus status;
    private String supplierName;
    private BigDecimal totalAmount;
    private Integer totalQuantity;
    private List<PurchaseOrderItemResponse> items;
    private LocalDateTime createdAt;
}
