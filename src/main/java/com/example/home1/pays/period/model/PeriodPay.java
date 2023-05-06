package com.example.home1.pays.period.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "period_pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodPay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String periodPay;

}
