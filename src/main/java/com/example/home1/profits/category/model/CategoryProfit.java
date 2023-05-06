package com.example.home1.profits.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category_profits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "category_profit")
    String categoryProfit;
    @ManyToOne
    @JoinColumn(name = "vid_category_profit_id")
    VidCategoryProfit vidCategoryProfit;
}
