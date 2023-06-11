package com.example.home1.pays.pay.controller;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.service.CategoryPayService;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayDtoCreate;
import com.example.home1.pays.pay.dto.PayEditDto;
import com.example.home1.pays.pay.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/pay")
@AllArgsConstructor
public class PayController {
    private final PayService payService;
    private final CategoryPayService categoryPayService;


    @GetMapping("/{id}")
    public String findPayById(@PathVariable(name = "id") Long id,
                              Model model) {
        System.out.println("Получен запрос GET /find?id=" + id);
        model.addAttribute("pay", payService.findById(id));
        model.addAttribute("category", categoryPayService.getCategoryPay());
        return "pay-edit";
    }

    @PostMapping("/edit")
    public String editPay(PayEditDto payEditDto) {
        System.out.println("Получен запрос GET /edit " + payEditDto);
        payService.editPay(payEditDto);
        return "redirect:/pay";
    }

    @PostMapping()
    public String addPay(PayDtoCreate payDtoCreate) {
        System.out.println("Получен запрос POST /pay " + payDtoCreate);
        payService.addPay(payDtoCreate);

        return "redirect:/pay";
    }

    @GetMapping()
    public String getPays(@RequestParam(name = "day1", required = false) String start,
                          @RequestParam(name = "day2", required = false) String end,
                          @RequestParam(name = "categoryPay", required = false) String categoryPay,
                          @RequestParam(name = "vidCategoryPay", required = false) String vidCategoryPay,
                          Model model) {
        System.out.println("Получен запрос GET /pay");
        List<PayDto> pays = payService.gedPayByPeriod(start, end, categoryPay, vidCategoryPay);
        System.out.println(pays);
        List<CategoryPay> catList = categoryPayService.getCategoryPay();
        Set<String> categoriesPay = catList.stream()
                .map(CategoryPay::getCategoryPay)
                .collect(Collectors.toSet());
        Set<String> vidCategoriesPay = catList.stream()
                .map(p -> p.getVidCategoryPay().getVidCategoryPay())
                .collect(Collectors.toSet());
        model.addAttribute("pays", pays);
        model.addAttribute("category", catList);
        model.addAttribute("listCategories", categoriesPay);
        model.addAttribute("vidCategoryPay", vidCategoriesPay);
        Integer totallPay = pays.stream()
                .mapToInt(PayDto::getPay)
                .sum();
        model.addAttribute("totallPay", totallPay);
        return "pays";
    }

    ///pay/delete?payId=
    @PostMapping("/delete")
    public String deletePeriod(@RequestParam Long payId) {
        System.out.println("Получен запрос POST /delete?payId=" + payId);
        payService.deletePeriod(payId);
        return "redirect:/pay";
    }
}
