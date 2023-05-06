package com.example.home1.profits.profit.storage;

import com.example.home1.profits.profit.model.Profit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProfitStorage extends JpaRepository<Profit, Long> {

    @Query("select p from Profit as p " +
            "where " +
            "p.timeProfit between :start and :end " +
            "and " +
            "(p.categoryProfit.categoryProfit like %:cP%)" +
            "and " +
            "(p.categoryProfit.vidCategoryProfit.vidCategoryProfit like %:vCP%)")
    List<Profit> getProfitByParameters(LocalDate start, LocalDate end, String cP, String vCP);
}
