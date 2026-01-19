package com.hanifomar.procurement_app.purchaseorder.controller;

import com.hanifomar.procurement_app.purchaseorder.dto.CreatePurchaseOrderRequest;
import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;
import com.hanifomar.procurement_app.purchaseorder.dto.UpdatePurchaseOrderRequest;
import com.hanifomar.procurement_app.purchaseorder.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrderResponse> create(
            @RequestBody CreatePurchaseOrderRequest request,
            @RequestAttribute UUID userId
    ) {
        return ResponseEntity.ok(purchaseOrderService.create(request, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponse> getById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(purchaseOrderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrderResponse>> getAll() {
        return ResponseEntity.ok(purchaseOrderService.findAll());
    }

    @PatchMapping("/{id}/submit")
    public ResponseEntity<PurchaseOrderResponse> submitPo(@PathVariable UUID id) {
        return ResponseEntity.ok(purchaseOrderService.submit(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrderResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdatePurchaseOrderRequest request
    ) {
        return ResponseEntity.ok(purchaseOrderService.update(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePo(@PathVariable UUID id) {
        purchaseOrderService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }


}

