package com.hanifomar.procurement_app.purchaseorder.service.impl;

import com.hanifomar.procurement_app.purchaseorder.dto.CreatePurchaseOrderRequest;
import com.hanifomar.procurement_app.purchaseorder.dto.PurchaseOrderResponse;
import com.hanifomar.procurement_app.purchaseorder.mapper.PurchaseOrderMapper;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrder;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderItem;
import com.hanifomar.procurement_app.purchaseorder.model.PurchaseOrderStatus;
import com.hanifomar.procurement_app.purchaseorder.repository.PurchaseOrderRepository;
import com.hanifomar.procurement_app.purchaseorder.service.PurchaseOrderService;
import com.hanifomar.procurement_app.supplier.model.Supplier;
import com.hanifomar.procurement_app.supplier.repository.SupplierRepository;
import com.hanifomar.procurement_app.user.model.User;
import com.hanifomar.procurement_app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final SupplierRepository supplierRepository;
    private final UserRepository userRepository;
    private final PurchaseOrderMapper mapper;

    @Override
    public PurchaseOrderResponse create(CreatePurchaseOrderRequest request, UUID userId) {

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        PurchaseOrder po = PurchaseOrder.builder()
                .poNumber(generatePoNumber())
                .status(PurchaseOrderStatus.DRAFT)
                .supplier(supplier)
                .createdBy(user)
                .totalAmount(BigDecimal.ZERO)
                .build();

        request.getItems().forEach(i -> {

            PurchaseOrderItem item = PurchaseOrderItem.builder()
                    .productName(i.getProductName())
                    .quantity(i.getQuantity())
                    .unitPrice(i.getUnitPrice())
                    .build();

            po.addItem(item);
        });

        BigDecimal totalAmount = po.getPurchaseOrderItemList().stream()
                .map(PurchaseOrderItem::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        po.setTotalAmount(totalAmount);

        poRepository.save(po);

        return mapper.toResponse(po);

    }

    @Override
    public PurchaseOrderResponse getById(UUID id) {

        PurchaseOrder po = poRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase Order not found"));

        return mapper.toResponse(po);
    }

    @Override
    public List<PurchaseOrderResponse> findAll() {
        List<PurchaseOrder> orders = poRepository.findAll();

        return mapper.toResponseList(orders);
    }

    private String generatePoNumber() {
        return "PO-" + System.currentTimeMillis();
    }
}
