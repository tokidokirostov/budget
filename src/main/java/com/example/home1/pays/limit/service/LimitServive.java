package com.example.home1.pays.limit.service;

import com.example.home1.pays.limit.dto.LimitDtoCreate;
import com.example.home1.pays.limit.dto.LimitMapper;
import com.example.home1.pays.limit.model.Limit;
import com.example.home1.pays.category.storage.CategoryPayStorage;
import com.example.home1.pays.limit.storage.LimitStorage;
import com.example.home1.pays.period.storage.PeriodPayStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LimitServive {
    private final LimitStorage limitStorage;
    private final CategoryPayStorage categoryPayStorage;
    private final PeriodPayStorage periodPayStorage;

    public List<Limit> viewLimits() {
        return limitStorage.findAll();
    }

    public Limit addLimit(LimitDtoCreate limits) {
        Limit limit = LimitMapper.toLimit(limits,
                categoryPayStorage.findById(limits.getCategoryPayId()).get(),
                periodPayStorage.findById(limits.getPeriodPayId()).get());
        return limitStorage.save(limit);
    }
}
