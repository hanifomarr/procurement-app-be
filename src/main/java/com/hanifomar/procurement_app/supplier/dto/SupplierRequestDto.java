package com.hanifomar.procurement_app.supplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequestDto {

    @NotBlank(message = "Supplier name is required")
    private String name;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @Pattern(
            regexp = "^[+]?\\d{7,15}$",
            message = "Phone number must be valid"
    )
    private String phone;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;
}
