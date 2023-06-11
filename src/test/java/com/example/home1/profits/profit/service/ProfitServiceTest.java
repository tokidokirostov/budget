package com.example.home1.profits.profit.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;
import com.example.home1.profits.category.storage.CategoryProfitStorage;
import com.example.home1.profits.profit.dto.ProfitCrateDto;
import com.example.home1.profits.profit.dto.ProfitDto;
import com.example.home1.profits.profit.dto.ProfitEditDto;
import com.example.home1.profits.profit.dto.ProfitMapper;
import com.example.home1.profits.profit.model.Profit;
import com.example.home1.profits.profit.storage.ProfitStorage;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProfitServiceTest {

    @Mock
    private ProfitStorage profitStorage;

    @Mock
    private CategoryProfitStorage categoryProfitStorage;

    @InjectMocks
    private ProfitService profitService;

    @Test
    void whenTryGetProfitByPeriodWithoutParameters_thenReturnEmptyList() {

        doReturn(List.of()).when(profitStorage).getProfitByParameters(any(), any(), any(), any());

        List<ProfitDto> actualResult = profitService.gedProfitByPeriod(null, null, null, null);

        assertEquals(actualResult, List.of());
    }

    @Test
    void whenTryGetProfitByPeriodWithParameters_thenReturnListProfitDto() {

        LocalDate date = LocalDate.parse("2023-02-02");
        Profit profit = getProfit();
        doReturn(List.of(profit))
                .when(profitStorage)
                .getProfitByParameters(eq(date), eq(date), any(), any());

        List<ProfitDto> actualResult = profitService.gedProfitByPeriod("2023-02-02", "2023-02-02", null, null);

        assertEquals(actualResult, List.of(ProfitMapper.toProfitDto(profit)));
    }

    @Test
    void whenTryAddProfitWithCategoryProfitInBase_thenOneRunProfitStorage() {

        ProfitCrateDto profitCrateDto = getProfitCrateDto();
        doReturn(Optional.of(getCategoryProfit())).when(categoryProfitStorage).findById(profitCrateDto.getCategoryProfitId());
        doReturn(getProfit()).when(profitStorage).save(any());

        profitService.addProfit(profitCrateDto);

        verify(profitStorage, times(1)).save(any());
    }

    @Test
    void whenTryAddProfitWithoutCategoryProfitInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, () -> profitService.addProfit(getProfitCrateDto()));
    }

    @Test
    void whenTryDeleteProfit_thenRunOneProfitStore() {

        profitService.deleteProfit(anyLong());

        verify(profitStorage, times(1)).deleteById(anyLong());
    }

    @Test
    void  whenTryFindByIdWithoutProfitInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, ()-> profitService.findById(anyLong()));
    }

    @Test
    void  whenTryFindByIdWithProfitInBase_thenReturnProfit() {

        Profit profit = getProfit();
        doReturn(Optional.of(profit)).when(profitStorage).findById(anyLong());

        ProfitDto actualResult = profitService.findById(anyLong());

        assertEquals(actualResult, ProfitMapper.toProfitDto(profit));
    }

    @Test
    void whenTryEditProfitWithoutCategoryProfitInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, ()-> profitService.editProfit(getProfitEditDto()));
    }

    @Test
    void whenTryEditProfitWithCategoryProfitInBase_thenReturnCustomException() {

        ProfitEditDto profitEditDto = getProfitEditDto();
        doReturn(Optional.of(getCategoryProfit())).when(categoryProfitStorage).findById(profitEditDto.getId());

        profitService.editProfit(profitEditDto);

        verify(profitStorage, times(1)).save(any());
    }

    private static ProfitEditDto getProfitEditDto() {
        return new ProfitEditDto(1L, 123, 1L, LocalDate.parse("2023-01-01"));
    }

    private static Profit getProfit() {
        return new Profit(1L, 100, getCategoryProfit(), LocalDate.parse("2023-01-01"));
    }

    private static CategoryProfit getCategoryProfit() {
        return new CategoryProfit(1L, "Категория дохода", getVidCategoryProfit());
    }

    private static VidCategoryProfit getVidCategoryProfit() {
        return new VidCategoryProfit(1L, "Вид категории дохода");
    }

    private static ProfitCrateDto getProfitCrateDto() {
        return new ProfitCrateDto( 100, 1L, LocalDate.now());
    }
}