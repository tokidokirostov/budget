package com.example.home1.pays.pay.service;

import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.limit.storage.LimitStorage;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayDtoCreate;
import com.example.home1.pays.pay.dto.PayMapper;
import com.example.home1.pays.pay.model.Pay;
import com.example.home1.pays.pay.storage.PayStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PayService {
    private final PayStorage payStorage;
    private final CategoryPayStorage categoryPayStorage;

    public List<PayDto> viewPays() {
        return payStorage.findAll().stream()
                .map(pay -> PayMapper.toPayDto(pay))
                .collect(Collectors.toList());
    }

    public PayDto addPay(PayDtoCreate payDtoCreate) {
        Pay pay = PayMapper.toPay(
                payDtoCreate,
                categoryPayStorage.findById(payDtoCreate.getCategoryId()).get()
        );
        return PayMapper.toPayDto(payStorage.save(pay));
    }

    public List<PayDto> findByDay(LocalDate localDate) {
        return payStorage.findByTimePay(localDate).stream()
                .map(pay -> PayMapper.toPayDto(pay))
                .collect(Collectors.toList());
    }

    public List<PayDto> gedDayByPeriod(String start, String end, String vidCategoryPay, String categoryPay) {
        LocalDate startDay;
        LocalDate endDay;
        if (start == null) {
            startDay = LocalDate.now();
        } else startDay = LocalDate.parse(start);
        if (end == null) {
            endDay = LocalDate.now();
        } else endDay = LocalDate.parse(end);
        return payStorage.getPayByParameters(startDay, endDay, vidCategoryPay, categoryPay).stream()
                .map(pay -> PayMapper.toPayDto(pay))
                .collect(Collectors.toList());
    }

    public void deletePeriod(Long payId) {
        payStorage.deleteById(payId);
    }
}
