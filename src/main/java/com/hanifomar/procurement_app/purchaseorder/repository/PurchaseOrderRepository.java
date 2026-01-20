package com.hanifomar.procurement_app.purchaseorder.repository;

import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {
    Long countByStatus(PurchaseOrderStatus status);

    @Query("SELECT COALESCE(SUM(p.totalAmount), 0) FROM PurchaseOrder p")
    BigDecimal sumTotalAmount();
}
