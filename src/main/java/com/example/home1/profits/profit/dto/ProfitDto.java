package com.example.home1.profits.profit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProfitDto {

    Long id;
    Integer profit;
    String categoryProfit;
    String vidCategoryProfit;
    LocalDate timeProfit;
}
