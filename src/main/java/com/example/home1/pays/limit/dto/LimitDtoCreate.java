package com.example.home1.pays.limit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitDtoCreate {
    private Long categoryPayId;
    private int limitPay;
    private Long periodPayId;

    @Override
    public String toString() {
        return "LimitDtoCreate{" +
                "categoryPayId=" + categoryPayId +
                ", limitPay=" + limitPay +
                ", periodPayId=" + periodPayId +
                '}';
    }
}
