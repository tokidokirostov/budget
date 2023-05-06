package com.example.home1.pays.category.dto;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;

public class CategoryPayMapper {

    public static VidCategoryPay toVidPeriodPay(VidCategoryPayCreateDto vidCategoryPayCreateDto) {
        return new VidCategoryPay(null, vidCategoryPayCreateDto.getVidCategoryPay());
    }

    public static CategoryPay toCategoryPay(CategoryPayCreateDto categoryPayCreateDto, VidCategoryPay vidCategoryPay) {
        return new CategoryPay(null, categoryPayCreateDto.getCategory(), vidCategoryPay);
    }

}
