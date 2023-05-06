package com.example.home1.pays.period.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PeriodPayCreateDto {

    Long id;
    String periodPay;

    @Override
    public String toString() {
        return "PeriodPayCreateDto{" +
                "id=" + id +
                ", periodPay='" + periodPay + '\'' +
                '}';
    }
}
