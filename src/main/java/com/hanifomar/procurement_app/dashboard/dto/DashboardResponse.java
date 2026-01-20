package com.hanifomar.procurement_app.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class DashboardResponse {

    private Long totalPurchaseOrders;
    private Long pendingApprovals;
    private Long totalSuppliers;
    private BigDecimal totalSpent;

    private List<RecentPurchaseOrder> recentPurchaseOrders = new ArrayList<>();
    private List<SupplierStat> supplierStats = new ArrayList<>();

    @Data
    @AllArgsConstructor
    public static class RecentPurchaseOrder {
        private String poNumber;
        private String supplierName;
        private BigDecimal totalAmount;
        private String status;
        private LocalDate orderDate;
    }

    @Data
    @AllArgsConstructor
    public static class SupplierStat {
        private String supplierName;
        private Long totalOrders;
        private BigDecimal totalSpent;
    }
}
