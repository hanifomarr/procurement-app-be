package com.hanifomar.procurement_app.purchaseorder.repository;

import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItem, UUID> {
}
