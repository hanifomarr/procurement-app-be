package com.hanifomar.procurement_app.supplier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequestDto {
    private String name;
    private String contactEmail;
    private String phone;
    private String address;
}
