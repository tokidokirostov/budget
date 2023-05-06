
package com.example.home1.pays.period.storage;

import com.example.home1.pays.period.model.PeriodPay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodPayStorage extends JpaRepository<PeriodPay, Long> {

}

