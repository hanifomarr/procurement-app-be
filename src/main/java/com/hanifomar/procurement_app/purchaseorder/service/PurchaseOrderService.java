package com.hanifomar.procurement_app.purchaseorder.service;

import com.hanifomar.procurement_app.purchaseorder.dto.CreatePurchaseOrderRequest;
import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;
import com.hanifomar.procurement_app.purchaseorder.dto.UpdatePurchaseOrderRequest;

import java.util.List;
import java.util.UUID;

public interface PurchaseOrderService {
    PurchaseOrderResponse create(CreatePurchaseOrderRequest request, UUID userId);

    PurchaseOrderResponse getById(UUID id);

    List<PurchaseOrderResponse> findAll();

    PurchaseOrderResponse submit(UUID poId);

    PurchaseOrderResponse update(UUID poId, UpdatePurchaseOrderRequest request);

    void delete(UUID poId);

}
