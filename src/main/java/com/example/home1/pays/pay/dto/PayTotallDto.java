package com.example.home1.pays.pay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PayTotallDto {
    Integer month;
    Integer main;
    Integer other;
    Integer notMain;
    Integer totall;
    Integer profit;
}
