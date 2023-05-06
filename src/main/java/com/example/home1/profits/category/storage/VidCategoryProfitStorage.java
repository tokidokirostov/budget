package com.example.home1.profits.category.storage;

import com.example.home1.profits.category.model.VidCategoryProfit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VidCategoryProfitStorage extends JpaRepository<VidCategoryProfit, Long> {
}
