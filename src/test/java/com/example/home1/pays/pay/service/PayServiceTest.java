package com.example.home1.pays.pay.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.pay.dto.PayDto;
import com.example.home1.pays.pay.dto.PayDtoCreate;
import com.example.home1.pays.pay.dto.PayEditDto;
import com.example.home1.pays.pay.dto.PayMapper;
import com.example.home1.pays.pay.model.Pay;
import com.example.home1.pays.pay.storage.PayStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PayServiceTest {

    @Mock
    PayStorage payStorage;
    @Mock
    CategoryPayStorage categoryPayStorage;
    @InjectMocks
    PayService payService;

    @Test
    void whenTryViewPaysWithPaysInBase_thenReturnListPays() {
        doReturn(List.of(getPay())).when(payStorage).findAll();

        List<PayDto> actualResult = payService.viewPays();

        assertEquals(actualResult.size(), 1);
    }

    @Test
    void whenAddPayWithoutCategoryPayInBase_thenReturnCustomException() {
        assertThrows(NotFoundDataException.class, () -> payService.addPay(getPayDtoCreate()));
    }

    @Test
    void whenAddPayWithCategoryPayInBase_thenReturnOncePayStorage() {
        Pay pay = getPay();
        PayDtoCreate payDtoCreate = getPayDtoCreate();
        doReturn(Optional.of(getCategoryPay())).when(categoryPayStorage).findById(payDtoCreate.getCategoryId());
        doReturn(pay).when(payStorage).save(any());

        payService.addPay(payDtoCreate);

        verify(payStorage, times(1)).save(any());
    }

    @Test
    void findByDay() {
        doReturn(List.of(getPay())).when(payStorage).findByTimePay(any());

        List<PayDto> actualresult = payService.findByDay(any());

        assertEquals(actualresult, List.of(getPayDto()));
    }

    @Test
    void whenGedDayByPeriodWithCorrectTimes_thenReturnListPayDto() {
        LocalDate date = LocalDate.parse("2023-02-02");
        doReturn(List.of(getPay())).when(payStorage)
                .getPayByParameters(eq(date), eq(date),
                        anyString(), anyString());

        List<PayDto> actualResult = payService.gedPayByPeriod("2023-02-02", "2023-02-02", "fff", "fff");

        assertEquals(actualResult, List.of(getPayDto()));
    }

    @Test
    void whenGedDayByPeriodWithInCorrectTimes_thenReturnEmptyList() {
        doReturn(List.of()).when(payStorage)
                .getPayByParameters(any(), any(),
                        anyString(), anyString());

        List<PayDto> actualResult = payService.gedPayByPeriod(null, null, null, null);

        assertEquals(actualResult, List.of());
    }

    @Test
    void deletePeriod() {
        payService.deletePeriod(2L);

        verify(payStorage, times(1)).deleteById(2L);
    }

    @Test
    void whenTryFindByIdWithoutPayInBase_thenReturnCustomException() {
        assertThrows(NotFoundDataException.class, () -> payService.findById(anyLong()));
    }

    @Test
    void whenTryFindByIdWithPayInBase_thenReturnPay() {
        doReturn(Optional.of(getPay())).when(payStorage).findById(anyLong());

        PayDto actualResult = payService.findById(anyLong());

        assertEquals(actualResult, PayMapper.toPayDto(getPay()));
    }

    @Test
    void whenTryEditPayWithoutPayInBase_thenReturnCustomException() {
        assertThrows(NotFoundDataException.class, () -> payService.editPay(getPayEditDto()));
    }

    @Test
    void whenTryEditPayWithPayInBase_thenReturnPay() {
        doReturn(Optional.of(getCategoryPay())).when(categoryPayStorage).findById(anyLong());

        payService.editPay(getPayEditDto());

        verify(categoryPayStorage, times(1)).findById(anyLong());
    }

    private static PayEditDto getPayEditDto() {
        return new PayEditDto(1L, 1L, 123, LocalDate.now());
    }

    private static Pay getPay() {
        return new Pay(1L, 123, getCategoryPay(), LocalDate.parse("2023-02-02"));
    }

    private static VidCategoryPay getVidCategoryPay() {
        return new VidCategoryPay(1L, "Вид категории");
    }

    private static CategoryPay getCategoryPay() {
        return new CategoryPay(1L, "Категория", getVidCategoryPay());
    }

    private static PayDto getPayDto() {
        return new PayDto(1L, 123, "Категория", "Вид категории",
                LocalDate.parse("2023-02-02"));
    }

    private static PayDtoCreate getPayDtoCreate() {
        return new PayDtoCreate(1L, 123, LocalDate.parse("2022-02-02"));
    }
}