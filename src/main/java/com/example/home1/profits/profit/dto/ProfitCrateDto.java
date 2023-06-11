package com.example.home1.profits.profit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data@AllArgsConstructor
public class ProfitCrateDto {

    //Long id;
    Integer profit;
    Long categoryProfitId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    LocalDate timeProfit;
}
