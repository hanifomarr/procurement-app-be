package com.hanifomar.procurement_app.dashboard.service.impl;

import com.hanifomar.procurement_app.dashboard.dto.DashboardResponse;
import com.hanifomar.procurement_app.dashboard.mapper.DashboardMapper;
import com.hanifomar.procurement_app.dashboard.service.DashboardService;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderStatus;
import com.hanifomar.procurement_app.purchaseorder.repository.PurchaseOrderRepository;
import com.hanifomar.procurement_app.supplier.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;
    private final DashboardMapper dashboardMapper;

    @Override
    public DashboardResponse getDashboardData() {

        Long totalPO = purchaseOrderRepository.count();
        Long pendingPO = purchaseOrderRepository.countByStatus(PurchaseOrderStatus.DRAFT);
        Long totalSuppliers = supplierRepository.count();
        BigDecimal totalSpent = purchaseOrderRepository.sumTotalAmount();

        // Recent POs with supplier
        List<DashboardResponse.RecentPurchaseOrder> recentPOs = purchaseOrderRepository
                .findTop5WithSupplier(PageRequest.of(0, 5))
                .stream()
                .map(dashboardMapper::toRecentPO)
                .toList();

        // Supplier stats
        List<DashboardResponse.SupplierStat> supplierStats = purchaseOrderRepository.getSupplierStats()
                .stream()
                .map(obj -> dashboardMapper.toSupplierStat(
                        (String) obj[0],
                        ((Long) obj[1]),
                        (BigDecimal) obj[2]
                ))
                .toList();

        return dashboardMapper.toDto(
                totalPO,
                pendingPO,
                totalSuppliers,
                totalSpent,
                recentPOs,
                supplierStats
        );
    }
}


