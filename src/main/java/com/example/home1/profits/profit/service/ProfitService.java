package com.example.home1.profits.profit.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.profits.category.storage.CategoryProfitStorage;
import com.example.home1.profits.profit.dto.ProfitCrateDto;
import com.example.home1.profits.profit.dto.ProfitDto;
import com.example.home1.profits.profit.dto.ProfitEditDto;
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
        LocalDate startDay = (start == null) ? LocalDate.now() : LocalDate.parse(start);
        LocalDate endDay = (end == null) ? LocalDate.now() : LocalDate.parse(end);
        if (categoryProfit == null) {
            categoryProfit = "";
        }
        if (vidCategoryProfit == null) {
            vidCategoryProfit = "";
        }
        return profitStorage.getProfitByParameters(startDay, endDay, categoryProfit, vidCategoryProfit).stream()
                .map(ProfitMapper::toProfitDto)
                .collect(Collectors.toList());
    }

    public void addProfit(ProfitCrateDto profitCrateDto) {
        Profit profit = ProfitMapper.toProfit(
                profitCrateDto,
                categoryProfitStorage.findById(profitCrateDto.getCategoryProfitId())
                        .orElseThrow(() -> new NotFoundDataException("При добавлении дохода не найдена категория дохода"))
        );
        profitStorage.save(profit);
    }

    public void deleteProfit(Long profitId) {
        profitStorage.deleteById(profitId);
    }

    public ProfitDto findById(Long id) {

        return ProfitMapper.toProfitDto(profitStorage.findById(id)
                .orElseThrow(() -> new NotFoundDataException("Не найден доход"))
        );
    }

    public void editProfit(ProfitEditDto profitEditDto) {
        Profit profit = ProfitMapper.toProfitEdit(
                profitEditDto,
                categoryProfitStorage.findById(profitEditDto.getCategoryProfitId())
                        .orElseThrow(() -> new NotFoundDataException("При изменении дохода не найдена категория дохода"))
        );
        profitStorage.save(profit);
    }
}