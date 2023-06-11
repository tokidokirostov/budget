package com.example.home1.main.service;

import com.example.home1.main.storage.SearchPayStorage;
import com.example.home1.pays.pay.dto.PayCalcDto;
import com.example.home1.pays.pay.dto.PayTotallDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class Mainservice {

    @Autowired
    SearchPayStorage searchPayStorage;

    public List<PayCalcDto> calcMonth(Integer year) {
        return searchPayStorage.calcPays(getYear(year));
    }

    public Map<String, Integer> getMonths(List<PayCalcDto> payCalcDtoList) {
        Map<String, Integer> months = new HashMap<>();

        Integer january = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getJanuary)
                .sum();
        Integer february = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getFebruary)
                .sum();
        Integer march = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getMarch)
                .sum();
        Integer april = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getApril)
                .sum();
        Integer may = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getMay)
                .sum();
        Integer june = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getJune)
                .sum();
        Integer july = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getJuly)
                .sum();
        Integer august = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getAugust)
                .sum();
        Integer september = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getSeptember)
                .sum();
        Integer october = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getOctober)
                .sum();
        Integer november = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getNovember)
                .sum();
        Integer december = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getDecember)
                .sum();

        months.put(Months.JANUARY.name(), january);
        months.put(Months.FEBRUARY.name(), february);
        months.put(Months.MARCH.name(), march);
        months.put(Months.APRIL.name(), april);
        months.put(Months.MAY.name(), may);
        months.put(Months.JUNE.name(), june);
        months.put(Months.JULY.name(), july);
        months.put(Months.AUGUST.name(), august);
        months.put(Months.SEPTEMBER.name(), september);
        months.put(Months.OCTOBER.name(), october);
        months.put(Months.NOVEMBER.name(), november);
        months.put(Months.DECEMBER.name(), december);
        return months;
    }

    public List<PayTotallDto> calcYear(Integer year) {
        return searchPayStorage.calcYear(getYear(year));
    }

    private Integer getYear(Integer year) {
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        return year;
    }

}
