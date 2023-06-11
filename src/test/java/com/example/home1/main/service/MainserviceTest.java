package com.example.home1.main.service;

import com.example.home1.main.storage.SearchPayStorage;
import com.example.home1.pays.pay.dto.PayCalcDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainserviceTest {

    @Mock
    private SearchPayStorage searchPayStorage;
    @InjectMocks
    private Mainservice mainservice;


    @Test
    void whenTryCalcMonth_thenOneRunSearchPayStorage() {
        PayCalcDto payCalcDto = getPayCalcDto();
        doReturn(List.of(payCalcDto)).when(searchPayStorage).calcPays(anyInt());

        List<PayCalcDto> actualResult = mainservice.calcMonth(anyInt());

        verify(searchPayStorage, times(1)).calcPays(anyInt());
        assertEquals(actualResult, List.of(payCalcDto));
    }

    @Test
    void whenTryGetMonths_thenReturnMap() {

        PayCalcDto payCalcDto = getPayCalcDto();
        payCalcDto.setCategoryPay("Категория2");
        Map<String, Integer> month = new HashMap<>(Map.of(
                "JANUARY",2,
                "JUNE",12,
                "MAY", 10,
                "OCTOBER", 20,
                "DECEMBER", 24,
                "MARCH", 6,
                "FEBRUARY", 4,
                "AUGUST", 16,
                "JULY", 14,
                "SEPTEMBER", 18
        ));
        month.put("NOVEMBER", 22);
        month.put("APRIL", 8);
        Map<String, Integer> actualResult = mainservice.getMonths(List.of(getPayCalcDto(), payCalcDto));

        assertEquals(actualResult, month);
    }

    @Test
    void whenTryCalcYearWithYear_thenOneRunSearchPayStorage() {
        mainservice.calcYear(anyInt());

        verify(searchPayStorage, times(1)).calcYear(anyInt());
    }

    @Test
    void whenTryCalcYearWithoutYear_thenOneRunSearchPayStorage() {
        mainservice.calcYear(null);

        verify(searchPayStorage, times(1)).calcYear(anyInt());
    }

    private static PayCalcDto getPayCalcDto() {
        return new PayCalcDto("Категория1", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 20);
    }
}