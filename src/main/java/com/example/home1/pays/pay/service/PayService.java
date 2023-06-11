package com.example.home1.pays.pay.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayDtoCreate;
import com.example.home1.pays.pay.dto.PayEditDto;
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

    //??????????????????????????????????
    public List<PayDto> viewPays() {
        return payStorage.findAll().stream()
                .map(PayMapper::toPayDto)
                .collect(Collectors.toList());
    }

    //public PayDto addPay(PayDtoCreate payDtoCreate) {
    public void addPay(PayDtoCreate payDtoCreate) {
        Pay pay = PayMapper.toPay(
                payDtoCreate,
                categoryPayStorage.findById(payDtoCreate.getCategoryId())
                        .orElseThrow(() -> new NotFoundDataException("При добавлении покупки не найдена категория покупки"))
        );
        payStorage.save(pay);
    }

    //???????????????????
    public List<PayDto> findByDay(LocalDate localDate) {
        return payStorage.findByTimePay(localDate).stream()
                .map(PayMapper::toPayDto)
                .collect(Collectors.toList());
    }

    public List<PayDto> gedPayByPeriod(String start, String end, String vidCategoryPay, String categoryPay) {
        LocalDate startDay = (start == null) ? LocalDate.now() : LocalDate.parse(start);
        LocalDate endDay = (end == null) ? LocalDate.now() : LocalDate.parse(end);
        if (vidCategoryPay == null) {
            vidCategoryPay = "";
        }
        if (categoryPay == null) {
            categoryPay = "";
        }
        System.out.println(startDay);
        System.out.println(endDay);
        System.out.println(vidCategoryPay);
        System.out.println(categoryPay);
        return payStorage.getPayByParameters(startDay, endDay, vidCategoryPay, categoryPay).stream()
                .map(PayMapper::toPayDto)
                .collect(Collectors.toList());
    }

    public void deletePeriod(Long payId) {
        payStorage.deleteById(payId);
    }

    public PayDto findById(Long id) {
        return PayMapper.toPayDto(payStorage.findById(id)
                .orElseThrow(() -> new NotFoundDataException("Покупка не найдена"))
        );
    }

    public void editPay(PayEditDto payEditDto) {
        Pay pay = PayMapper.toPayEdit(
                payEditDto,
                categoryPayStorage.findById(payEditDto.getCategoryId())
                        .orElseThrow(() -> new NotFoundDataException("При изменении покупки не найдена категория покупки"))
        );
        payStorage.save(pay);
    }
}
