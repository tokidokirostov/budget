package com.example.home1.pays.category.storage;

import com.example.home1.pays.category.model.CategoryPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryPayStorage extends JpaRepository<CategoryPay, Long> {

}
