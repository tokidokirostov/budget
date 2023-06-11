package com.example.home1.pays.category.controller;

import com.example.home1.pays.category.dto.CategoryPayCreateDto;
import com.example.home1.pays.category.dto.CategoryPayDto;
import com.example.home1.pays.category.dto.VidCategoryPayCreateDto;
import com.example.home1.pays.category.dto.VidCategoryPayDto;
import com.example.home1.pays.category.service.CategoryPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/pay/category")
public class CategoryPayController {
    private final CategoryPayService categoryPayService;

    @GetMapping()
    public String vievsCategoryPay(Model model) {
        System.out.println("Получен запрос GET /pay/category");
        model.addAttribute("categoryPayList", categoryPayService.getCategoryPay());
        model.addAttribute("vidCategoryPayList", categoryPayService.getVidCategoryPay());
        return "category-pay";
    }

    @PostMapping()
    public String addCategoryPay(CategoryPayCreateDto categoryPayCreateDto) {
        System.out.println("Получен запрос POST /pay/category " + categoryPayCreateDto);
        categoryPayService.addCategoryPay(categoryPayCreateDto);
        return "redirect:/pay/category";
    }

    @PostMapping("/edit")
    public String editCategoryPay(CategoryPayDto categoryPayDto) {
        System.out.println("Получен запрос POST /pay/category/edit " + categoryPayDto);
        categoryPayService.editCategoryPay(categoryPayDto);
        return "redirect:/pay/category";
    }

    @PostMapping ("/delete")
    public String deleteCategoryPay(@RequestParam Long category) {
        System.out.println("Получен запрос POST /pay/delete " + category);
        //categoryService.deleteCategoryPay(category);
        return "redirect:/pay/category";
    }

    //-------------------------------------------------------------------

    @GetMapping("/vid")
    public String vievsVidCategoryPay(Model model) {
        System.out.println("Получен запрос GET /pay/category/vid");
        model.addAttribute("list", categoryPayService.getVidCategoryPay());
        return "vid-category-pay";
    }

    @PostMapping("/vid")
    public String addVidCategoryPay(VidCategoryPayCreateDto vidCategoryPayCreateDto) {
        System.out.println("Получен запрос POST /pay/category/vid " + vidCategoryPayCreateDto);
        categoryPayService.addVidCategoryPay(vidCategoryPayCreateDto);
        return "redirect:/pay/category/vid";
    }

    @PostMapping("/vid/edit")
    public String editVidCategoryPay(VidCategoryPayDto vidCategoryPayDto) {
        System.out.println("Получен запрос POST /pay/category/vid/edit " + vidCategoryPayDto);
        categoryPayService.editVidCategoryPay(vidCategoryPayDto);
        return "redirect:/pay/category/vid";
    }

    ///period/delete?period1=
    @PostMapping ("/vid/delete")
    public String deleteCategoryPayVid(@RequestParam Long idVidCategoryPay) {
        System.out.println("Получен запрос POST /pay/category/vid/delete?period1=" + idVidCategoryPay);
        categoryPayService.deleteVidCategoryPay(idVidCategoryPay);
        return "redirect:/pay/category/vid";
    }
}
