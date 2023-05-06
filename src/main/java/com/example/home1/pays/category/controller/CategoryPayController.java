package com.example.home1.pays.category.controller;

import com.example.home1.pays.category.dto.CategoryPayCreateDto;
import com.example.home1.pays.category.dto.CategoryPayDto;
import com.example.home1.pays.category.dto.VidCategoryPayCreateDto;
import com.example.home1.pays.category.dto.VidCategoryPayDto;
import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import com.example.home1.pays.category.service.CategoryPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/pay/category")
public class CategoryPayController {
    private final CategoryPayService categoryPayService;

    @GetMapping()
    public String vievsCategoryPay(Model model) {
        System.out.println("Получен запрос GET /pay/category");
        List<CategoryPay> categoryPayList = categoryPayService.getCategory();
        List<VidCategoryPay> vidCategoryPayList = categoryPayService.getCategoryVid();
        System.out.println(categoryPayList);
        System.out.println(vidCategoryPayList);
        model.addAttribute("categoryPayList", categoryPayList);
        model.addAttribute("vidCategoryPayList", vidCategoryPayList);
        return "category-pay";
    }

    @PostMapping()
    public String addCategoryPay(CategoryPayCreateDto categoryPayCreateDto) {
        System.out.println("Получен запрос POST /pay/category");

        System.out.println("111 " + categoryPayCreateDto);
        categoryPayService.addCategory(categoryPayCreateDto);
        return "redirect:/pay/category";
    }

    @PostMapping("{id}")
    public String editCategoryPay(@PathVariable Long id,
                                  CategoryPayDto categoryPayDto) {
        System.out.println("Получен запрос POST /pay/category/edit");
        System.out.println(id);
        System.out.println("category " + categoryPayDto);
        categoryPayService.editCategoryPay(categoryPayDto);
        return "redirect:/pay/category";
    }

    @PostMapping ("/delete")
    public String deleteCategoryPay(@RequestParam Long category) {
        System.out.println("Удаление " + category);
        //categoryService.deleteCategory(category);
        return "redirect:/pay/category";
    }

    //-------------------------------------------------------------------

    @GetMapping("/vid")
    public String vievsVidCategoryPay(Model model) {
        System.out.println("Получен запрос GET /pay/category/vid");
        List<VidCategoryPay> list = categoryPayService.getCategoryVid();
        System.out.println(list);
        model.addAttribute("list", list);
        return "vid-category-pay";
    }

    @PostMapping("/vid")
    public String addVidCategoryPay(VidCategoryPayCreateDto vidCategoryPayCreateDto) {
        System.out.println("Получен запрос POST /pay/category/vid");
        System.out.println(vidCategoryPayCreateDto);
        categoryPayService.addVidCategoryPay(vidCategoryPayCreateDto);
        return "redirect:/pay/category/vid";
    }

    @PostMapping("/vid/{id}")
    public String editVidCategoryPay(@PathVariable Long id,
            VidCategoryPayDto vidCategoryPayDto) {
        System.out.println("Получен запрос POST /pay/category/vid/" + id);
        System.out.println(vidCategoryPayDto);
        categoryPayService.editVidCategoryPay(vidCategoryPayDto);
        return "redirect:/pay/category/vid";
    }

    ///period/delete?period1=
    @PostMapping ("/vid/delete")
    public String deleteCategoryPayVid(@RequestParam Long idVidCategoryPay) {
        System.out.println("Получен запрос POST /pay/category/vid/delete");
        System.out.println("Удаление " + idVidCategoryPay);
        categoryPayService.deleteVidCategoryPay(idVidCategoryPay);
        return "redirect:/pay/category/vid";
    }
}
