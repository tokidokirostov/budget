package com.example.home1.profits.category.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.profits.category.dto.*;
import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;
import com.example.home1.profits.category.storage.CategoryProfitStorage;
import com.example.home1.profits.category.storage.VidCategoryProfitStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryProfitService {
    private final VidCategoryProfitStorage vidCategoryProfitStorage;
    private final CategoryProfitStorage categoryProfitStorage;

    public void addVidCategoryProfit(VidCategoryProfitCreateDto vidCategoryProfitCreateDto) {
        vidCategoryProfitStorage.save(CategoryProfitMapper.toVidCategoryProfit(vidCategoryProfitCreateDto));
    }

    public List<VidCategoryProfit> getVidCategoriesProfit() {
        return vidCategoryProfitStorage.findAll();
    }

    public void addCategoryProfit(CategoryProfitCreateDto categoryProfitCreateDto) {
        VidCategoryProfit vidCategoryProfit = vidCategoryProfitStorage.findById(categoryProfitCreateDto.getVidCategoryProfitId())
                .orElseThrow(() -> new NotFoundDataException("Не найден вид категории дохода"));
        categoryProfitStorage.save(CategoryProfitMapper.toCategoryProfit(
                categoryProfitCreateDto,
                vidCategoryProfit));
    }

    public List<CategoryProfit> getCategoriesProfit() {
        return categoryProfitStorage.findAll();
    }

    public void editVidCategoryProfit(VidCategoryProfitDto vidCategoryProfitDto) {
        VidCategoryProfit vidCategoryProfit = vidCategoryProfitStorage.findById(vidCategoryProfitDto.getId())
                .orElseThrow(() -> new NotFoundDataException("Не найден вид категории дохода"));
        vidCategoryProfit.setVidCategoryProfit(vidCategoryProfitDto.getVidCategoryProfit());
        vidCategoryProfitStorage.save(vidCategoryProfit);
    }

    public void editCategoryProfit(CategoryProfitDto categoryProfitDto) {
        CategoryProfit categoryProfit = categoryProfitStorage.findById(categoryProfitDto.getId())
                .orElseThrow(() -> new NotFoundDataException("Не найдена категория дохода"));
        categoryProfit.setCategoryProfit(categoryProfitDto.getCategoryProfit());
        categoryProfitStorage.save(categoryProfit);
    }
}
