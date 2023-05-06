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
    //private final PayService payService;
    private final PayService payService;
    private final Mainservice mainservice;

    //@Autowired
    //SearchPayStorage storage;


    @GetMapping("/")
    public String home(Model model) {
        LocalDate date = LocalDate.now();
        List<PayDto> pays = payService.gedDayByPeriod(date.toString(), date.toString(), null, null);
        System.out.println(pays);
        model.addAttribute("pays", pays);
        LocalDate now = LocalDate.now();
        List<PayCalcDto> payCalcDtoList = mainservice.calculationPay(now, now);
        //LocalDate localDate = LocalDate.now();
        //Day day = new Day(1L, localDate, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18);
        //Day day = new Day(1L, localDate, 1);
        //System.out.println(day);
        //daysRepository.save(day);
        //Day dayFromBd = dayService.getDay(localDate);
        //System.out.println(dayFromBd);
        //dayFromBd.getId();
        //model.addAttribute("day", dayFromBd);
        /*model.addAttribute("mainLimit", limitServive.getMainLimit());
        model.addAttribute("mainLimitYear", limitServive.getMainLimitYear());
        System.out.println("Из базы " + limitServive.getOtherLimit());
        model.addAttribute("otherlimit", limitServive.getOtherLimit());*/
        model.addAttribute("calcs", payCalcDtoList);

        return "Home";
    }

    //months?year=2023
    @GetMapping("/months")
    public String months(@RequestParam(name = "year", required = false) Integer year,
                         Model model) {
        System.out.println("Получен запрос GET /months");
        List<PayCalcDto> payCalcDtoList = mainservice.calcMonth(year);

        model.addAttribute("calcs", payCalcDtoList);
        model.addAttribute("yan", mainservice.getMonths(payCalcDtoList).get("yan"));
        model.addAttribute("fev", mainservice.getMonths(payCalcDtoList).get("fev"));
        model.addAttribute("mart", mainservice.getMonths(payCalcDtoList).get("mart"));
        model.addAttribute("apr", mainservice.getMonths(payCalcDtoList).get("apr"));
        model.addAttribute("may", mainservice.getMonths(payCalcDtoList).get("may"));
        model.addAttribute("yun", mainservice.getMonths(payCalcDtoList).get("yun"));
        model.addAttribute("yul", mainservice.getMonths(payCalcDtoList).get("yul"));
        model.addAttribute("avgu", mainservice.getMonths(payCalcDtoList).get("avgu"));
        model.addAttribute("sept", mainservice.getMonths(payCalcDtoList).get("sept"));
        model.addAttribute("oct", mainservice.getMonths(payCalcDtoList).get("oct"));
        model.addAttribute("nov", mainservice.getMonths(payCalcDtoList).get("nov"));
        model.addAttribute("decb", mainservice.getMonths(payCalcDtoList).get("decb"));
        //model.addAttribute("apr", apr);

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

    //Поиск по дате
    @GetMapping("/date")
    public String find(@RequestParam(name = "day", required = false) String day, Model model) {
        System.out.println("Получен запрос GET /date");
        System.out.println(day);
        List<PayDto> pays = payService.findByDay(LocalDate.parse(day));
        System.out.println(pays);
        model.addAttribute("pays", pays);
        return "Search";
    }

    //calculation?day1=2023-03-01&day2=2023-03-31
    @GetMapping("/calculation")
    public String findThePeriod(@RequestParam(name = "day1", required = false) String start,
                                @RequestParam(name = "day2", required = false) String end,
                                Model model) {
        System.out.println("day1 " + start);
        System.out.println("day2 " + end);
        List<PayDto> pays = payService.gedDayByPeriod(start, end, null, null);
        System.out.println(pays);
        model.addAttribute("pays", pays);
        //System.out.println(mainservice.calculationPay(LocalDate.parse(start), LocalDate.parse(end)));
        mainservice.calculationPay(LocalDate.parse(start), LocalDate.parse(end));

        //Day day1 = daysRepository.getDayByDay1(LocalDate.parse(day));
        //System.out.println(day1);
        //model.addAttribute("day", day1);*//*
        //payService.gedDayByPeriod(day1, day2);
        //List<Day> list = daysRepository.findDaysByDay1Between(LocalDate.parse(day1), LocalDate.parse(day2));


        //List<Pay> list = payService.gedDayByPeriod(start, end);
        //System.out.println("выборка за период" + list);


        //System.out.println("dddd " + payStorage.findBy(LocalDate.parse(start), LocalDate.parse(end)));
        //List<PayNoDateDto> list1 = storage.findPays(LocalDate.parse(start), LocalDate.parse(end));

        //List<PayNoDateDto> list1 = payService.gedDayByPeriodTotall(LocalDate.parse(start), LocalDate.parse(end));
        //System.out.println("Spisok totall " + list1);
        //model.addAttribute("list", list);
        //model.addAttribute("list1", list1);


        return "calculation";
    }

    //Сохранение в базу
    /*@PostMapping("/create")
    public String createProduct(Day day) {
        //public String createProduct(DayDto day) {
        //System.out.println(day);
        System.out.println(day);
        //System.out.println("В базе " + dayService.saveDay(day));
        return "redirect:/";
    }*/
}
