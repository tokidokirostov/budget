package com.example.home1.main.service;

import com.example.home1.main.storage.SearchPayStorage;
import com.example.home1.pays.pay.dto.PayCalcDto;
import com.example.home1.pays.pay.dto.PayTotallDto;
import com.example.home1.pays.pay.storage.PayStorage;
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
    PayStorage payStorage;

    @Autowired
    SearchPayStorage searchPayStorage;

    public List<PayCalcDto> calcMonth(Integer year) {
        return searchPayStorage.calcPays(getYear(year));
    }

    public Map<String, Integer> getMonths(List<PayCalcDto> payCalcDtoList) {
        Map<String, Integer> months = new HashMap<>();
        Integer yan = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getYan)
                .sum();
        Integer fev = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getFev)
                .sum();
        Integer mart = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getMart)
                .sum();
        Integer apr = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getApr)
                .sum();
        Integer may = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getMay)
                .sum();
        Integer yun = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getYun)
                .sum();
        Integer yul = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getYul)
                .sum();
        Integer avgu = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getAvgu)
                .sum();
        Integer sept = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getSept)
                .sum();
        Integer oct = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getOct)
                .sum();
        Integer nov = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getNov)
                .sum();
        Integer decb = payCalcDtoList.stream()
                .mapToInt(PayCalcDto::getDecb)
                .sum();

        months.put("yan", yan);
        months.put("fev", fev);
        months.put("mart", mart);
        months.put("apr", apr);
        months.put("may", may);
        months.put("yun", yun);
        months.put("yul", yul);
        months.put("avgu", avgu);
        months.put("sept", sept);
        months.put("oct", oct);
        months.put("nov", nov);
        months.put("decb", decb);
        return months;
    }

    public List<PayTotallDto> calcYear(Integer year) {
        return searchPayStorage.calcYear(getYear(year));
    }

    public List<PayCalcDto> calculationPay(LocalDate start, LocalDate end) {
        //System.out.println("Из базы " + payStorage.calc(start, end));
        //System.out.println("Из базы " + searchPayStorage.calcPays());
        return null;
    }

    private Integer getYear(Integer year) {
        if (year == null) {
            year = LocalDate.now().getYear();
        }
        return year;
    }
    /*public List<PayNoDateDto> gedDayByPeriodTotall(LocalDate start, LocalDate end) {
        List<Limit> limitList = limitStorage.findAll();
        List<PayNoDateDto> payNoDateDtoList = searchPayStorage.findPays(start, end);
        for (PayNoDateDto payNoDateDto : payNoDateDtoList) {
            for (Limit limit : limitList) {
                if (limit.getCategory().getCategory().equals(payNoDateDto.getCategory())) {
                    payNoDateDto.setOstatok(limit.getLimit1() - payNoDateDto.getPay());
                    //System.out.println(limit.getCategory().getCategory());
                    //System.out.println(payNoDateDto.getCategory());
                }
            }
        }
        return payNoDateDtoList;
    }*/
}
