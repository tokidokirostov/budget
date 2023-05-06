package com.example.home1.profits.profit.model;

import com.example.home1.profits.category.model.CategoryProfit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "profits")
public class Profit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer profit;
    @ManyToOne
    @JoinColumn(name = "category_profit_id")
    CategoryProfit categoryProfit;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "time_profit")
    LocalDate timeProfit;
}
