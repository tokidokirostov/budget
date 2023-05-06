package com.example.home1.pays.limit.model;

import com.example.home1.pays.period.model.PeriodPay;
import com.example.home1.pays.category.model.CategoryPay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "limit_pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "category_pay_id")
    CategoryPay categoryPay;
    @Column(name = "limit_pay")
    Integer limitPay;
    @ManyToOne
    @JoinColumn(name = "period_pay_id")
    PeriodPay periodPay;
}
