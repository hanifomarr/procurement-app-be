package com.hanifomar.procurement_app.purchaseorder.service;

import com.hanifomar.procurement_app.purchaseorder.dto.CreatePurchaseOrderRequest;
import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;

import java.util.List;
import java.util.UUID;

public interface PurchaseOrderService {
    PurchaseOrderResponse create(CreatePurchaseOrderRequest request, UUID userId);

    PurchaseOrderResponse getById(UUID id);

    List<PurchaseOrderResponse> findAll();

    PurchaseOrderResponse submit(UUID poId);

    void delete(UUID poId);
}
