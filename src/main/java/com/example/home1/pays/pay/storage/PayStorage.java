package com.example.home1.pays.pay.storage;

import com.example.home1.pays.pay.dto.PayNoDateDto;
import com.example.home1.pays.pay.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PayStorage extends JpaRepository<Pay, Long> {

    List<Pay> findByTimePay(LocalDate localDate);

    @Query("select p from Pay as p where " +
            "p.timePay between :start and :end " +
            "and " +
            "(p.categoryPay.categoryPay like %:cP%) " +
            "and " +
            "(p.categoryPay.vidCategoryPay.vidCategoryPay like %:vCP%)")
    List<Pay> getPayByParameters(LocalDate start, LocalDate end, String cP, String vCP);
}
