package com.example.home1.pays.limit.controller;

import com.example.home1.pays.category.service.CategoryPayService;
import com.example.home1.pays.limit.dto.LimitDtoCreate;
import com.example.home1.pays.limit.model.Limit;
import com.example.home1.pays.limit.service.LimitServive;
import com.example.home1.pays.period.service.PeriodPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/limit")
public class LimitController {
    private final LimitServive limitServive;
    private final CategoryPayService categoryPayService;
    private final PeriodPayService periodPayService;


    @PostMapping()
    public String addMainLimit(LimitDtoCreate limits) {
        System.out.println("Получен запрос POST /limit");
        System.out.println(limits);
        limitServive.addLimit(limits);
        //System.out.println("In base" + limitServive.addMainLimit(limitMain));
        return "redirect:/limit";
    }

    @GetMapping()
    public String getLimits(Model model) {
        //public String getLimits() {
        System.out.println("Получен запрос GET /limit");
        List<Limit> list = limitServive.viewLimits();
        System.out.println(list);
        model.addAttribute("list", list);
        model.addAttribute("category", categoryPayService.getCategory());
        model.addAttribute("period", periodPayService.viewPeriods());
        //model.addAttribute("impot", importanceService.viewPeriods());


        return "limits";
    }


}
