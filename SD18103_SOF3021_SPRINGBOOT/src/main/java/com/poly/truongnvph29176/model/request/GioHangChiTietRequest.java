package com.poly.truongnvph29176.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GioHangChiTietRequest implements Serializable {
    private UUID gioHang;
    private UUID chiTietSP;
}
