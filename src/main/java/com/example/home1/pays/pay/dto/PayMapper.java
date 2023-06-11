package com.example.home1.pays.pay.dto;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.pay.model.Pay;

public class PayMapper {

    public static Pay toPay(PayDtoCreate payDtoCreate, CategoryPay categoryPay) {
        return new Pay(
                null,
                payDtoCreate.getPay(),
                categoryPay,
                payDtoCreate.getTimePay()
        );
    }

    public static Pay toPayEdit(PayEditDto payEditDto, CategoryPay categoryPay) {
        return new Pay(
                payEditDto.getId(),
                payEditDto.getPay(),
                categoryPay,
                payEditDto.getTimePay()
        );
    }

    public static PayDto toPayDto(Pay pay) {
        return new PayDto(
                pay.getId(),
                pay.getPay(),
                pay.getCategoryPay().getCategoryPay(),
                pay.getCategoryPay().getVidCategoryPay().getVidCategoryPay(),
                pay.getTimePay()
        );
    }
}
