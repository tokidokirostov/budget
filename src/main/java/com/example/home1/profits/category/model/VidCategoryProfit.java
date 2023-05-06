package com.example.home1.profits.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vid_category_profits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VidCategoryProfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "vid_category_profit")
    String vidCategoryProfit;
}
