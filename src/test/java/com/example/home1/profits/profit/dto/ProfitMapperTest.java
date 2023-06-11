package com.example.home1.profits.profit.dto;

import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;
import com.example.home1.profits.profit.model.Profit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProfitMapperTest {

    @Test
    void toProfitDto() {
        ProfitDto profitDto = new ProfitDto(null, 123, "Категория", "Вид категории", LocalDate.parse("2023-02-02"));

        ProfitDto actualResult = ProfitMapper.toProfitDto(getProfit());

        assertEquals(actualResult, profitDto);
    }

    @Test
    void toProfit() {
        ProfitCrateDto profitCrateDto = new ProfitCrateDto(123, 1L, LocalDate.parse("2023-02-02"));

        Profit actualResult = ProfitMapper.toProfit(profitCrateDto, getCategoryProfit());

        assertEquals(actualResult, getProfit());
    }

    @Test
    void toProfitEdit() {
        ProfitEditDto profitEditDto = new ProfitEditDto(1L, 123, 1L, LocalDate.parse("2023-02-02"));
        Profit profit = getProfit();
        profit.setId(1L);

        Profit actualResult = ProfitMapper.toProfitEdit(profitEditDto, getCategoryProfit());

        assertEquals(actualResult, profit);
    }


    private static Profit getProfit() {
        return new Profit(null, 123, getCategoryProfit(), LocalDate.parse("2023-02-02"));
    }

    private static CategoryProfit getCategoryProfit() {
        return new CategoryProfit(null, "Категория", getVidCategoryProfit());
    }

    private static VidCategoryProfit getVidCategoryProfit() {
        return new VidCategoryProfit(1L, "Вид категории");
    }
}