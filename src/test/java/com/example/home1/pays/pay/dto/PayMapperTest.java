package com.example.home1.pays.pay.dto;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import com.example.home1.pays.pay.model.Pay;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayMapperTest {

    @Test
    void toPay() {

        PayDtoCreate payDtoCreate = new PayDtoCreate(null, 123, LocalDate.parse("2023-02-02"));

        Pay actualResult = PayMapper.toPay(payDtoCreate, getCategoryPay());

        assertEquals(actualResult, getPay());
    }

    @Test
    void toPayDto() {

        PayDto payDto = new PayDto(null, 123, "Категория", "Вид категории", LocalDate.parse("2023-02-02"));

        PayDto actualResult = PayMapper.toPayDto(getPay());

        assertEquals(actualResult, payDto);
    }

    @Test
    void toPayEdit() {

        PayEditDto payEditDto = new PayEditDto(1L, 1L, 123, LocalDate.parse("2023-02-02"));
        Pay pay = getPay();
        pay.setId(1L);

        Pay actualResult = PayMapper.toPayEdit(payEditDto, getCategoryPay());


        assertEquals(actualResult, pay);
    }

    private static Pay getPay() {
        return new Pay(null, 123, getCategoryPay(), LocalDate.parse("2023-02-02"));
    }

    private static CategoryPay getCategoryPay() {
        return new CategoryPay(null, "Категория", getVidCategoryPay());
    }

    private static VidCategoryPay getVidCategoryPay() {
        return new VidCategoryPay(1L, "Вид категории");
    }
}