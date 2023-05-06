package com.example.home1.profits.profit.dto;

import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.profit.model.Profit;

public class ProfitMapper {

    public static ProfitDto toProfitDto(Profit profit) {
        return new ProfitDto(
                profit.getId(),
                profit.getProfit(),
                profit.getCategoryProfit().getCategoryProfit(),
                profit.getCategoryProfit().getVidCategoryProfit().getVidCategoryProfit(),
                profit.getTimeProfit()
        );
    }

    public static Profit toProfit(ProfitCrateDto profitCrateDto, CategoryProfit categoryProfit) {
        return new Profit(null, profitCrateDto.getProfit(), categoryProfit, profitCrateDto.getTimeProfit());
    }
}
