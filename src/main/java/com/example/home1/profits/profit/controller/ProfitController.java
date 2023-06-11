package com.example.home1.profits.profit.controller;

import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.service.CategoryProfitService;
import com.example.home1.profits.profit.dto.ProfitCrateDto;
import com.example.home1.profits.profit.dto.ProfitDto;
import com.example.home1.profits.profit.dto.ProfitEditDto;
import com.example.home1.profits.profit.service.ProfitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/profit")
@AllArgsConstructor
public class ProfitController {
    private final ProfitService profitService;
    private final CategoryProfitService categoryProfitService;

    @GetMapping("{id}")
    public String findProfitById(@PathVariable(name = "id") Long id,
                                 Model model) {
        model.addAttribute("category", categoryProfitService.getCategoriesProfit());
        model.addAttribute("profit", profitService.findById(id));
        return "profit-edit";
    }

    @PostMapping("/edit")
    public String editProfit(ProfitEditDto profitEditDto) {
        System.out.println("Получен запрос GET /edit " + profitEditDto);
        profitService.editProfit(profitEditDto);
        return "redirect:/profit";
    }

    @GetMapping()
    public String getProfits(@RequestParam(name = "day1", required = false) String start,
                             @RequestParam(name = "day2", required = false) String end,
                             @RequestParam(name = "categoryProfit", required = false) String categoryProfit,
                             @RequestParam(name = "vidCategoryProfit", required = false) String vidCategoryProfit,
                             Model model) {
        System.out.println("Получен запрос GET /profit");
        List<ProfitDto> profits = profitService.gedProfitByPeriod(start, end, categoryProfit, vidCategoryProfit);
        List<CategoryProfit> categoriesProfit = categoryProfitService.getCategoriesProfit();
        Set<String> listCategories = categoriesProfit.stream().
                map(CategoryProfit::getCategoryProfit)
                .collect(Collectors.toSet());
        Set<String> listVidCategories = categoriesProfit.stream()
                .map(ss -> ss.getVidCategoryProfit().getVidCategoryProfit())
                .collect(Collectors.toSet());
        model.addAttribute("profits", profits);
        model.addAttribute("category", categoriesProfit);
        model.addAttribute("vidCategoryProfit", listVidCategories);
        model.addAttribute("listCategories", listCategories);
        Integer total = profits.stream()
                .mapToInt(ProfitDto::getProfit)
                .sum();
        model.addAttribute("total", total);
        System.out.println(listVidCategories);
        return "profits";
    }

    @PostMapping
    public String addProfit(ProfitCrateDto profitCrateDto) {
        System.out.println("Получен запрос POST /profit " + profitCrateDto);
        profitService.addProfit(profitCrateDto);
        return "redirect:/profit";
    }

    //delete?profitId=
    @PostMapping("/delete")
    public String deleteProfit(@RequestParam(name = "profitId") Long profitId) {
        System.out.println("Получен запрос POST /profit/delete?profitId=" + profitId);
        profitService.deleteProfit(profitId);
        return "redirect:/profit";
    }
}
