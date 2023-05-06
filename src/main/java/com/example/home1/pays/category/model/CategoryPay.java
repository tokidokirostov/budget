package com.example.home1.pays.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "category_pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String categoryPay;
    @ManyToOne
    @JoinColumn(name = "vid_category_pay_id")
    VidCategoryPay vidCategoryPay;
}
