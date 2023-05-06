package com.example.home1.pays.pay.controller;

import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.service.CategoryPayService;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayDtoCreate;
import com.example.home1.pays.pay.model.Pay;
import com.example.home1.pays.pay.service.PayService;
import com.example.home1.pays.period.service.PeriodPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/pay")
@AllArgsConstructor
public class PayController {
    private final PayService payService;
    private final CategoryPayService categoryPayService;
    private final PeriodPayService periodPayService;

    @PostMapping()
    public String addPay(PayDtoCreate payDtoCreate) {
        System.out.println(payDtoCreate);
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
        //LocalDate date = LocalDate.now();
        System.out.println(categoryPay);
        System.out.println(vidCategoryPay);
        List<PayDto> pays = payService.gedDayByPeriod(start, end, categoryPay, vidCategoryPay);
        //List<PayDto> pays = payService.gedDayByPeriod(date.toString(), date.toString());
        //List<PayDto> pays = payService.viewPays();
        List<CategoryPay> catList = categoryPayService.getCategory();
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

        //model.addAttribute("period", periodPayService.viewPeriods());
        return "pays";
    }

    ///pay/delete?payId=
    @PostMapping ("/delete")
    public String deletePeriod(@RequestParam Long payId) {
        System.out.println("Получен запрос POST /delete");
        System.out.println("Удаление " + payId);
        payService.deletePeriod(payId);
        return "redirect:/pay";
    }
}
