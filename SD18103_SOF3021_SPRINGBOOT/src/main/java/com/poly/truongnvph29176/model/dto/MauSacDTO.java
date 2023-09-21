package com.poly.truongnvph29176.model.dto;

import jakarta.validation.constraints.NotBlank;
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
public class MauSacDTO {
    private UUID id;
    private String ma;

    @NotBlank(message = "Không được để trống")
    private String ten;
}
