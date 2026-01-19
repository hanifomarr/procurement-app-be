package com.hanifomar.procurement_app.purchaseorder.model;

import com.hanifomar.procurement_app.supplier.model.Supplier;
import com.hanifomar.procurement_app.user.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "purchase_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "po_number", nullable = false, unique = true, updatable = false)
    private String poNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PurchaseOrderStatus status;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    @OneToMany(
            mappedBy = "purchaseOrder",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    @Builder.Default
    private List<PurchaseOrderItem> purchaseOrderItemList = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public void addItem(PurchaseOrderItem item) {
        purchaseOrderItemList.add(item);
        item.setPurchaseOrder(this);
    }

    public void removeItem(PurchaseOrderItem item) {
        purchaseOrderItemList.remove(item);
        item.setPurchaseOrder(null);
    }

    public Integer getTotalQuantity() {
        return purchaseOrderItemList
                .stream()
                .mapToInt(PurchaseOrderItem::getQuantity)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(poNumber, that.poNumber) && status == that.status && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, poNumber, status, totalAmount, createdAt, updatedAt);
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void OnUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
