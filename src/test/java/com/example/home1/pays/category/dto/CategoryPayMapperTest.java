package com.example.home1.pays.category.dto;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryPayMapperTest {

    @Test
    void toVidPeriodPay() {
        VidCategoryPayCreateDto vidCategoryPayCreateDto = new VidCategoryPayCreateDto("Вид категории");
        VidCategoryPay vidCategoryPay = new VidCategoryPay(null, "Вид категории");

        VidCategoryPay actualResult = CategoryPayMapper.toVidPeriodPay(vidCategoryPayCreateDto);

        assertEquals(actualResult, vidCategoryPay);
    }

    @Test
    void toCategoryPay() {
        CategoryPayCreateDto categoryPayCreateDto = new CategoryPayCreateDto("Категория", 1L);
        VidCategoryPay vidCategoryPay = new VidCategoryPay(1L, "Вид категории");
        CategoryPay categoryPay = new CategoryPay(null, "Категория", vidCategoryPay);


        CategoryPay actualResult = CategoryPayMapper.toCategoryPay(categoryPayCreateDto, vidCategoryPay);

        assertEquals(actualResult, categoryPay);
    }
}