package com.hanifomar.procurement_app.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class DashboardResponse {

    private Long totalPurchaseOrders;
    private Long pendingApprovals;
    private Long totalSuppliers;
    private BigDecimal totalSpent;
}
