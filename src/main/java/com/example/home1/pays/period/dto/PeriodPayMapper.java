package com.example.home1.pays.period.dto;

import com.example.home1.pays.period.model.PeriodPay;

public class PeriodPayMapper {
    public static PeriodPay toPeriodPay(PeriodPayCreateDto periodPayCreateDto) {
        return new PeriodPay(periodPayCreateDto.getId(), periodPayCreateDto.getPeriodPay());
    }
}
