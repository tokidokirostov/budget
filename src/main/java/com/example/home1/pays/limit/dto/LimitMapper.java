package com.example.home1.pays.limit.dto;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.limit.model.Limit;
import com.example.home1.pays.period.model.PeriodPay;

public class LimitMapper {

    public static Limit toLimit(LimitDtoCreate limitDtoCreate, CategoryPay categoryPay, PeriodPay periodPay) {
        return new Limit(
                null,
                categoryPay,
                limitDtoCreate.getLimitPay(),
                periodPay
        );
    }
}
