package com.example.home1.pays.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PayDto {

    Long id;
    Integer pay;
    String categoryPay;
    String vidCategoryPay;
    LocalDate timePay;

}
