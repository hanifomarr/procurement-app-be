package com.hanifomar.procurement_app.purchaseorder.repository;

import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, UUID> {
}
