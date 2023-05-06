
package com.example.home1.pays.period.service;

import com.example.home1.pays.period.model.PeriodPay;
import com.example.home1.pays.period.storage.PeriodPayStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeriodPayService {
    private final PeriodPayStorage periodPayStorage;

    public PeriodPay addPeriod(PeriodPay period) {
        return periodPayStorage.save(period);
    }

    public List<PeriodPay> viewPeriods() {
        return periodPayStorage.findAll();
    }

    public void deletePeriod(Long id) {
        periodPayStorage.deleteById(id);
    }
}

