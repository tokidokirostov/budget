package com.example.home1.profits.profit.service;

import com.example.home1.profits.category.storage.CategoryProfitStorage;
import com.example.home1.profits.profit.dto.ProfitCrateDto;
import com.example.home1.profits.profit.dto.ProfitDto;
import com.example.home1.profits.profit.dto.ProfitMapper;
import com.example.home1.profits.profit.model.Profit;
import com.example.home1.profits.profit.storage.ProfitStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProfitService {
    private final ProfitStorage profitStorage;
    private final CategoryProfitStorage categoryProfitStorage;

    public List<ProfitDto> gedProfitByPeriod(String start, String end, String categoryProfit, String vidCategoryProfit) {
        LocalDate startDay;
        LocalDate endDay;
        if (start == null) {
            startDay = LocalDate.now();
        } else startDay = LocalDate.parse(start);
        if (end == null) {
            endDay = LocalDate.now();
        } else endDay = LocalDate.parse(end);
        return profitStorage.getProfitByParameters(startDay, endDay, categoryProfit, vidCategoryProfit).stream()
                .map(ProfitMapper::toProfitDto)
                .collect(Collectors.toList());
    }

    public ProfitDto addProfit(ProfitCrateDto profitCrateDto) {
        Profit profit = ProfitMapper.toProfit(
                profitCrateDto,
                categoryProfitStorage.findById(profitCrateDto.getCategoryProfitId()).get()
        );
        return ProfitMapper.toProfitDto(profitStorage.save(profit));
    }

    public void deleteProfit(Long profitId) {
        profitStorage.deleteById(profitId);
    }
}