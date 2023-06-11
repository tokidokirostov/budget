package com.example.home1.profits.category.dto;

import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryProfitMapperTest {

    @Test
    void toCategoryProfit() {
        CategoryProfitCreateDto categoryProfitCreateDto = new CategoryProfitCreateDto("Категория", 1L);
        VidCategoryProfit vidCategoryProfit = new VidCategoryProfit(1L, "Вид категории");
        CategoryProfit categoryProfit = new CategoryProfit(null, "Категория", vidCategoryProfit);

        CategoryProfit actualResult = CategoryProfitMapper.toCategoryProfit(categoryProfitCreateDto, vidCategoryProfit);

        assertEquals(actualResult, categoryProfit);
    }

    @Test
    void toVidCategoryProfit() {
        VidCategoryProfit vidCategoryProfit = new VidCategoryProfit(1L, "Вид категории");
        VidCategoryProfitCreateDto vidCategoryProfitCreateDto = new VidCategoryProfitCreateDto("Вид категории", "Категория");

        VidCategoryProfit actualResult = CategoryProfitMapper.toVidCategoryProfit(vidCategoryProfitCreateDto);

        assertEquals(actualResult.getVidCategoryProfit(), vidCategoryProfit.getVidCategoryProfit());
    }

}