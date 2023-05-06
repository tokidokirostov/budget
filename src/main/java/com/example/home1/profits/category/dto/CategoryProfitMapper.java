package com.example.home1.profits.category.dto;

import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;

public class CategoryProfitMapper {

    public static CategoryProfit toCategoryProfit(CategoryProfitCreateDto categoryProfitCreateDto, VidCategoryProfit vidCategoryProfit) {
        return new CategoryProfit(
                null,
                categoryProfitCreateDto.getCategoryProfit(),
                vidCategoryProfit);
    }

    public static VidCategoryProfit toVidCategoryProfit(VidCategoryProfitCreateDto vidCategoryProfitCreateDto) {
        return new VidCategoryProfit(null, vidCategoryProfitCreateDto.getVidCategoryProfit());
    }
}
