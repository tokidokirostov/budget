package com.example.home1.pays.category.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vid_category_pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VidCategoryPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "vid_category_pay")
    String vidCategoryPay;
}
