package com.hanifomar.procurement_app.dashboard.mapper;

import com.hanifomar.procurement_app.dashboard.dto.DashboardResponse;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DashboardMapper {

    default DashboardResponse toDto(
            Long totalPurchaseOrders,
            Long pendingApprovals,
            Long totalSuppliers,
            BigDecimal totalSpent,
            List<DashboardResponse.RecentPurchaseOrder> recentPOs,
            List<DashboardResponse.SupplierStat> supplierStats
    ) {
        DashboardResponse dto = new DashboardResponse();
        dto.setTotalPurchaseOrders(totalPurchaseOrders);
        dto.setPendingApprovals(pendingApprovals);
        dto.setTotalSuppliers(totalSuppliers);
        dto.setTotalSpent(totalSpent != null ? totalSpent : BigDecimal.ZERO);
        dto.setRecentPurchaseOrders(recentPOs);
        dto.setSupplierStats(supplierStats);
        return dto;
    }

    default DashboardResponse.RecentPurchaseOrder toRecentPO(PurchaseOrder po) {
        return new DashboardResponse.RecentPurchaseOrder(
                po.getPoNumber(),
                po.getSupplier().getName(),  // Safe now because of fetch join
                po.getTotalAmount(),
                po.getStatus().name(),
                po.getCreatedAt().toLocalDate()
        );
    }

    default DashboardResponse.SupplierStat toSupplierStat(String supplierName, Long totalOrders, BigDecimal totalSpent) {
        return new DashboardResponse.SupplierStat(supplierName, totalOrders, totalSpent);
    }
}

