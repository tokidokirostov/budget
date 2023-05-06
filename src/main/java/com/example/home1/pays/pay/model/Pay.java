package com.example.home1.pays.pay.model;

import com.example.home1.pays.category.model.CategoryPay;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer pay;
    @ManyToOne
    @JoinColumn(name = "category_pay_id")
    CategoryPay categoryPay;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    @Column(name = "time_pay")
    LocalDate timePay;
}
