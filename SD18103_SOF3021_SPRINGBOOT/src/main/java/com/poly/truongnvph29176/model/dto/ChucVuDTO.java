package com.poly.truongnvph29176.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChucVuDTO {
    private UUID id;
    private String ma;
    @NotBlank(message = "Khong duoc de trong")
    @Size(min = 1, max = 50, message = "So luong ki tu lon hon 1 va nho hon 50")
    private String ten;
}
