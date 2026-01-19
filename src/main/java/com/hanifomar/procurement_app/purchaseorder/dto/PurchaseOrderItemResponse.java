package com.hanifomar.procurement_app.purchaseorder.dto;

import java.math.BigDecimal;

public class PurchaseOrderItemResponse {
    private String productName;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
}
