package com.hanifomar.procurement_app.purchaseorder.repository;

import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {

    Long countByStatus(PurchaseOrderStatus status);

    @Query("SELECT COALESCE(SUM(p.totalAmount), 0) FROM PurchaseOrder p")
    BigDecimal sumTotalAmount();

    @Query("SELECT p FROM PurchaseOrder p JOIN FETCH p.supplier ORDER BY p.createdAt DESC")
    List<PurchaseOrder> findTop5WithSupplier(Pageable pageable);

    @Query("""
        SELECT p.supplier.name, COUNT(p), COALESCE(SUM(p.totalAmount), 0)
        FROM PurchaseOrder p
        GROUP BY p.supplier.name
        """)
    List<Object[]> getSupplierStats();
}

