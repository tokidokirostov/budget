package com.example.home1.pays.category.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.pays.category.dto.*;
import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.category.storage.VidCategoryPayStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryPayService {
    private final CategoryPayStorage categoryPayStorage;
    private final VidCategoryPayStorage vidCategoryPayStorage;

    public List<CategoryPay> getCategoryPay() {
        return categoryPayStorage.findAll();
    }

    public void addCategoryPay(CategoryPayCreateDto categoryPayCreateDto) {
        System.out.println(categoryPayCreateDto);
        VidCategoryPay vidCategoryPay = vidCategoryPayStorage.findById(categoryPayCreateDto.getIdVidCategoryPay())
                .orElseThrow(() -> new NotFoundDataException("Не найден вид категории покупки"));

        categoryPayStorage.save(CategoryPayMapper.toCategoryPay(categoryPayCreateDto, vidCategoryPay));
    }

    public void deleteCategoryPay(Long category) {
        categoryPayStorage.deleteById(category);
    }

    public List<VidCategoryPay> getVidCategoryPay() {
        return vidCategoryPayStorage.findAll();
    }

    public void addVidCategoryPay(VidCategoryPayCreateDto vidCategoryPayCreateDto) {
        vidCategoryPayStorage.save(CategoryPayMapper.toVidPeriodPay(vidCategoryPayCreateDto));
    }

    public void deleteVidCategoryPay(Long idVidCategoryPay) {
        vidCategoryPayStorage.deleteById(idVidCategoryPay);
    }

    public void editCategoryPay(CategoryPayDto categoryPayDto) {
        CategoryPay categoryPay = categoryPayStorage.findById(categoryPayDto.getId())
                .orElseThrow(() -> new NotFoundDataException("Не найдена категория покупки"));
        categoryPay.setCategoryPay(categoryPayDto.getCategory());
        categoryPayStorage.save(categoryPay);
    }

    public void editVidCategoryPay(VidCategoryPayDto vidCategoryPayDto) {
        VidCategoryPay vidCategoryPay = vidCategoryPayStorage.findById(vidCategoryPayDto.getId())
                .orElseThrow(() -> new NotFoundDataException("Не найден вид категории покупки"));
        vidCategoryPay.setVidCategoryPay(vidCategoryPayDto.getVidCategoryPay());
        vidCategoryPayStorage.save(vidCategoryPay);
    }
}
