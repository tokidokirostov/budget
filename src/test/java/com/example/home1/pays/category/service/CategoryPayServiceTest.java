package com.example.home1.pays.category.service;

import com.example.home1.exception.NotFoundDataException;
import com.example.home1.pays.category.dto.CategoryPayCreateDto;
import com.example.home1.pays.category.dto.CategoryPayDto;
import com.example.home1.pays.category.dto.VidCategoryPayCreateDto;
import com.example.home1.pays.category.dto.VidCategoryPayDto;
import com.example.home1.pays.category.model.CategoryPay;
import com.example.home1.pays.category.model.VidCategoryPay;
import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.category.storage.VidCategoryPayStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryPayServiceTest {

    @Mock
    private CategoryPayStorage categoryPayStorage;
    @Mock
    private VidCategoryPayStorage vidCategoryPayStorage;

    @InjectMocks
    private CategoryPayService categoryPayService;

   @Test
    void whenGetCategoryWithoutPays_thenReturnEmptyList() {
        ArrayList<CategoryPay> categoryPaysEmpty = new ArrayList<>();
        doReturn(categoryPaysEmpty).when(categoryPayStorage).findAll();

        List<CategoryPay> actualResult = categoryPayService.getCategoryPay();

        assertEquals(actualResult, categoryPaysEmpty);
        verify(categoryPayStorage, times(1)).findAll();
    }

    @Test
    void whenTryGetCategoryWithPays_thenReturnListPays() {
        VidCategoryPay vidCategoryPay = getVidCategoryPay();
        CategoryPay categoryPay1 = new CategoryPay(null, "Категория1", vidCategoryPay);
        CategoryPay categoryPay2 = new CategoryPay(null, "Категория2", vidCategoryPay);
        CategoryPay categoryPay3 = new CategoryPay(null, "Категория3", vidCategoryPay);
        ArrayList<CategoryPay> categoryPays = new ArrayList<>();
        categoryPays.add(categoryPay1);
        categoryPays.add(categoryPay2);
        categoryPays.add(categoryPay3);
        doReturn(categoryPays).when(categoryPayStorage).findAll();

        List<CategoryPay> actualResult = categoryPayService.getCategoryPay();

        assertEquals(actualResult, categoryPays);
        assertEquals(actualResult.size(), 3);
        verify(categoryPayStorage, times(1)).findAll();
    }



    @Test
    void whenTryAddCategoryPayWithVidCategoryPayInBase_thenRunOnceCategoryPayStorage() {
        doReturn(Optional.of(getVidCategoryPay())).when(vidCategoryPayStorage).findById(any());

        categoryPayService.addCategoryPay(getCategoryPayCreateDto());

        verify(categoryPayStorage, times(1)).save(any());
    }



    @Test
    void whenTryAddCategoryPayWithoutVidCategoryPayInBase_thenReturnCustomException() {

       assertThrows(NotFoundDataException.class, () -> categoryPayService.addCategoryPay(getCategoryPayCreateDto()));
    }

    @Test
    void whenTryGetCategoryVidWithVidCategory_thenReturnListVidCategories() {
        doReturn(List.of(getVidCategoryPay())).when(vidCategoryPayStorage).findAll();

        List<VidCategoryPay> actualResult = categoryPayService.getVidCategoryPay();

        assertEquals(actualResult.size(), 1);

    }

    @Test
    void whenTryAddVidCategoryPay_thenOneRunCategoryPayStorage() {
        VidCategoryPayCreateDto vidCategoryPayCreateDto = new VidCategoryPayCreateDto("Категория");

        categoryPayService.addVidCategoryPay(vidCategoryPayCreateDto);

        verify(vidCategoryPayStorage, times(1)).save(any());
    }

    @Test
    void deleteVidCategoryPay() {
       categoryPayService.deleteVidCategoryPay(anyLong());

       verify(vidCategoryPayStorage, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteCategoryPay() {
        categoryPayService.deleteCategoryPay(anyLong());

        verify(categoryPayStorage, times(1)).deleteById(anyLong());
    }

    @Test
    void whenTryEditCategoryPayWithoutCategoryPayInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, () -> categoryPayService.editCategoryPay(getCategoryPayDto()));
    }

    @Test
    void whenTryEditCategoryPayWithCategoryPayInBase_thenRunOnceCategoryPayStorage() {

       CategoryPayDto categoryPayDto = getCategoryPayDto();
        CategoryPay categoryPay = new CategoryPay(null, "Категория", getVidCategoryPay());
        doReturn(Optional.of(categoryPay)).when(categoryPayStorage).findById(categoryPayDto.getId());

        categoryPayService.editCategoryPay(categoryPayDto);

        verify(categoryPayStorage, times(1)).save(categoryPay);
        assertEquals(categoryPay.getCategoryPay(), categoryPayDto.getCategory());
    }



    @Test
    void whenTryEditVidCategoryPayWithVidCategoryPayInBase_thenRunOnceCategoryPayStorage() {
        VidCategoryPayDto vidCategoryPayDto = getVidCategoryPayDto();
        VidCategoryPay vidCategoryPay = getVidCategoryPay();
        doReturn(Optional.of(vidCategoryPay)).when(vidCategoryPayStorage).findById(vidCategoryPayDto.getId());

        categoryPayService.editVidCategoryPay(vidCategoryPayDto);

        verify(vidCategoryPayStorage, times(1)).save(vidCategoryPay);
        assertEquals(vidCategoryPay.getVidCategoryPay(), vidCategoryPayDto.getVidCategoryPay());
    }

    @Test
    void whenTryEditVidCategoryPayWithoutVidCategoryPayInBase_thenReturnCustomException() {

        assertThrows(NotFoundDataException.class, ()-> categoryPayService.editVidCategoryPay(getVidCategoryPayDto()));
    }

    private static VidCategoryPayDto getVidCategoryPayDto() {
        return new VidCategoryPayDto(1L, "Исправленный вид");
    }

    private static VidCategoryPay getVidCategoryPay() {
        return new VidCategoryPay(1L, "Вид категории");
    }

    private static CategoryPayCreateDto getCategoryPayCreateDto() {
        return new CategoryPayCreateDto("Категория", 1L);
    }

    private static CategoryPayDto getCategoryPayDto() {
        return new CategoryPayDto(1L, "Измененная категория", 1L);
    }
}