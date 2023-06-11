package com.example.home1.profits.category.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.profits.category.dto.CategoryProfitCreateDto;
import com.example.home1.profits.category.dto.CategoryProfitDto;
import com.example.home1.profits.category.dto.VidCategoryProfitCreateDto;
import com.example.home1.profits.category.dto.VidCategoryProfitDto;
import com.example.home1.profits.category.model.CategoryProfit;
import com.example.home1.profits.category.model.VidCategoryProfit;
import com.example.home1.profits.category.storage.CategoryProfitStorage;
import com.example.home1.profits.category.storage.VidCategoryProfitStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryProfitServiceTest {

    @Mock
    private CategoryProfitStorage categoryProfitStorage;

    @Mock
    private VidCategoryProfitStorage vidCategoryProfitStorage;

    @InjectMocks
    private CategoryProfitService categoryProfitService;

    @Test
    void whenTryAddVidCategoryProfit_thenOneRunCategoryProfitStorage() {
        VidCategoryProfitCreateDto vidCategoryProfitCreateDto = new VidCategoryProfitCreateDto("Вид категории дохода", "Категории дохода");

        categoryProfitService.addVidCategoryProfit(vidCategoryProfitCreateDto);

        verify(vidCategoryProfitStorage, times(1)).save(any());
    }

    @Test
    void whenTryGetVidCategoriesProfit_thenReturnListVidCategoryProfit() {

        VidCategoryProfit vidCategoryProfit = getVidCategoryProfit();
        doReturn(List.of(vidCategoryProfit)).when(vidCategoryProfitStorage).findAll();

        List<VidCategoryProfit> actualResult = categoryProfitService.getVidCategoriesProfit();

        assertEquals(actualResult, List.of(vidCategoryProfit));
    }



    @Test
    void whenTryAddCategoryProfitWithoutVidCategoryProfit_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, () -> categoryProfitService.addCategoryProfit(getCategoryProfitCreateDto()));
    }

    @Test
    void whenTryAddCategoryProfitWithVidCategoryProfit_thenRunOnceCategoryProfitStorage() {

        doReturn(Optional.of(getVidCategoryProfit())).when(vidCategoryProfitStorage).findById(any());

        categoryProfitService.addCategoryProfit(getCategoryProfitCreateDto());

        verify(categoryProfitStorage, times(1)).save(any());
    }



    @Test
    void whenTrygetCategoriesProfitWithCategoryProfitInBase_thenReturnListCategoryProfit() {

        CategoryProfit categoryProfit = getCategoryProfit();
        doReturn(List.of(categoryProfit)).when(categoryProfitStorage).findAll();

        List<CategoryProfit> actualResult = categoryProfitService.getCategoriesProfit();

        assertEquals(actualResult, List.of(categoryProfit));
    }

    @Test
    void whenTryEditVidCategoryProfitWithoutVidCategoryProfitInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, () -> categoryProfitService.editVidCategoryProfit(getVidCategoryProfitDto()));
    }



    @Test
    void whenTryEditVidCategoryProfit_thenOneRunCategoryProfitStorage() {

        doReturn(Optional.of(getVidCategoryProfit())).when(vidCategoryProfitStorage).findById(anyLong());
        categoryProfitService.editVidCategoryProfit(getVidCategoryProfitDto());

        verify(vidCategoryProfitStorage, times(1)).save(any());
    }

    @Test
    void whenTryEditCategoryProfitWithoutVidCategoryProfitInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, () -> categoryProfitService.editCategoryProfit(getCategoryProfitDto()));
    }




    @Test
    void whenTryEditCategoryProfit_thenOneRunCategoryProfitStorage() {
        CategoryProfitDto categoryProfitDto = getCategoryProfitDto();
        doReturn(Optional.of(getCategoryProfit())).when(categoryProfitStorage).findById(categoryProfitDto.getId());
        categoryProfitService.editCategoryProfit(categoryProfitDto);

        verify(categoryProfitStorage, times(1)).save(any());
    }

    private static CategoryProfitDto getCategoryProfitDto() {
        return new CategoryProfitDto(1L, "www");
    }
    private static VidCategoryProfitDto getVidCategoryProfitDto() {
        return new VidCategoryProfitDto(1L, "Вид категории дохода new");
    }
    private static VidCategoryProfit getVidCategoryProfit() {
        return new VidCategoryProfit(1L, "Вид категории дохода");
    }

    private static CategoryProfitCreateDto getCategoryProfitCreateDto() {
        return new CategoryProfitCreateDto("Категория дохода", 1L);
    }

    private static CategoryProfit getCategoryProfit() {
        return new CategoryProfit(1L, "Категория дохода", getVidCategoryProfit());
    }
}