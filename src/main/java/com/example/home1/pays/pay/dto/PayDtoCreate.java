package com.example.home1.pays.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PayDtoCreate {

    Long categoryId;
    Integer pay;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    LocalDate timePay;

    @Override
    public String toString() {
        return "PayDtoCreate{" +
                "categoryId=" + categoryId +
                ", pay=" + pay +
                ", timePay=" + timePay +
                '}';
    }
}
