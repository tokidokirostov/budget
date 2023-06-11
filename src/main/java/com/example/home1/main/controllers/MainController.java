package com.example.home1.main.controllers;

import com.example.home1.main.service.Mainservice;
import com.example.home1.pays.pay.dto.PayCalcDto;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayTotallDto;
import com.example.home1.pays.pay.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final PayService payService;
    private final Mainservice mainservice;

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    //months?year=2023
    @GetMapping("/months")
    public String months(@RequestParam(name = "year", required = false) Integer year,
                         Model model) {
        System.out.println("Получен запрос GET /months");
        List<PayCalcDto> payCalcDtoList = mainservice.calcMonth(year);
        model.addAttribute("calcs", payCalcDtoList);
        model.addAttribute("months", mainservice.getMonths(payCalcDtoList));
        return "months";
    }

    @GetMapping("/year")
    public String totall(@RequestParam(name = "year", required = false) Integer year,
                         Model model) {
        System.out.println("Получен запрос GET /totall");
        List<PayTotallDto> payTotallDtoList = mainservice.calcYear(year);
        model.addAttribute("totalls", payTotallDtoList);
        return "year";
    }

    /*//Поиск по дате
    @GetMapping("/date")
    public String find(@RequestParam(name = "day", required = false) String day, Model model) {
        System.out.println("Получен запрос GET /date");
        System.out.println(day);
        List<PayDto> pays = payService.findByDay(LocalDate.parse(day));
        System.out.println(pays);
        model.addAttribute("pays", pays);
        return "Search";
    }*/
}
