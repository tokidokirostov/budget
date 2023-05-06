package com.example.home1.profits.category.controller;

import com.example.home1.profits.category.dto.CategoryProfitCreateDto;
import com.example.home1.profits.category.dto.CategoryProfitDto;
import com.example.home1.profits.category.dto.VidCategoryProfitCreateDto;
import com.example.home1.profits.category.dto.VidCategoryProfitDto;
import com.example.home1.profits.category.service.CategoryProfitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/profit/category")
public class CategoryProfitController {
    private final CategoryProfitService categoryProfitService;

    @GetMapping()
    public String viewsCategoryProfit(Model model) {
        System.out.println("Получен запрос GET /profit/category");
        model.addAttribute("vidCategoryProfit", categoryProfitService.getVidCategoriesProfit());
        model.addAttribute("categoryProfit", categoryProfitService.getCategoriesProfit());
        return "category-profit";
    }

    @PostMapping()
    public String addCategoryProfit(CategoryProfitCreateDto categoryProfitCreateDto) {
        System.out.println("Получен запрос POST /profit/category " + categoryProfitCreateDto);
        categoryProfitService.addCategoryProfit(categoryProfitCreateDto);
        return "redirect:/profit/category";
    }

    @PostMapping("{id}")
    public String editCategoryProfit(@PathVariable Long id,
                                     CategoryProfitDto categoryProfitDto) {
        System.out.println("Получен запрос POST /profit/category/" + id + " " + categoryProfitDto);
        categoryProfitService.editCategoryProfit(categoryProfitDto);
        return "redirect:/profit/category";
    }

    //----------------------------------------------------------------
    @GetMapping("/vid")
    public String viewsCategoryVidProfit(Model model) {
        System.out.println("Получен запрос GET /profit/category/vid");
        model.addAttribute("vidCategoriesProfit", categoryProfitService.getVidCategoriesProfit());
        return "vid-category-profit";
    }

    @PostMapping("/vid")
    public String addVidCategoryProfit(VidCategoryProfitCreateDto vidCategoryProfitCreateDto) {
        System.out.println("Получен запрос POST /profit/category/vid" + vidCategoryProfitCreateDto);
        categoryProfitService.addVidCategoryProfit(vidCategoryProfitCreateDto);
        return "redirect:/profit/category/vid";
    }

    @PostMapping("/vid/{id}")
    public String editVidCategoryProfit(@PathVariable Long id,
                                        VidCategoryProfitDto vidCategoryProfitDto) {
        System.out.println("Получен запрос POST /profit/category/vid/" + id + " " + vidCategoryProfitDto);
        categoryProfitService.editVidCategoryProfit(vidCategoryProfitDto);
        return "redirect:/profit/category/vid";
    }
}
