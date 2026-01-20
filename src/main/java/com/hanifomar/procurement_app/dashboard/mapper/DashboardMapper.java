package com.hanifomar.procurement_app.dashboard.mapper;

import com.hanifomar.procurement_app.dashboard.dto.DashboardResponse;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface DashboardMapper {

    default DashboardResponse toDto(
            Long totalPurchaseOrders,
            Long pendingApprovals,
            Long totalSuppliers,
            BigDecimal totalSpent
    ) {
        DashboardResponse dto = new DashboardResponse();
        dto.setTotalPurchaseOrders(totalPurchaseOrders);
        dto.setPendingApprovals(pendingApprovals);
        dto.setTotalSuppliers(totalSuppliers);
        dto.setTotalSpent(totalSpent != null ? totalSpent : BigDecimal.ZERO);
        return dto;
    }
}
