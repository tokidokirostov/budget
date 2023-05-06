package com.example.home1.pays.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryPayDto {

    Long id;
    String category;
    Long idVidCategoryPay;
}
