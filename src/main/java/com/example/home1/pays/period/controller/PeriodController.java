package com.example.home1.pays.period.controller;

import com.example.home1.pays.period.dto.PeriodPayCreateDto;
import com.example.home1.pays.period.dto.PeriodPayMapper;
import com.example.home1.pays.period.model.PeriodPay;
import com.example.home1.pays.period.service.PeriodPayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/pay/period")
public class PeriodController {
    private final PeriodPayService periodPayService;

    @GetMapping()
    public String viewPeriods(Model model) {
        System.out.println("Получен запрос GET /period");
        List<PeriodPay> list = periodPayService.viewPeriods();
        System.out.println(list);
        model.addAttribute("list", list);
        return "periods";
    }

    @PostMapping
    public String addPeriodPay(PeriodPayCreateDto period) {
        System.out.println("Получен запрос POST /period");
        System.out.println(period);
        periodPayService.addPeriod(PeriodPayMapper.toPeriodPay(period));
        return "redirect:/pay/period";
    }

    @PutMapping
    public String updatePeriodPay() {

        return "redirect:/pay/period";
    }

    ///period/delete?period1=
    @PostMapping ("/delete")
    //public void deletePeriod(@PathVariable String period1) {
    public String deletePeriod(@RequestParam Long period1) {
        System.out.println("Получен запрос POST /delete");
        System.out.println("Удаление " + period1);
        periodPayService.deletePeriod(period1);
        return "redirect:/pay/period";
    }
}
