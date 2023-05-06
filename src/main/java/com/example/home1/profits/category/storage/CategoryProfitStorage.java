package com.example.home1.profits.category.storage;

import com.example.home1.profits.category.model.CategoryProfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProfitStorage extends JpaRepository<CategoryProfit, Long> {
}
