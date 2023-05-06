package com.example.home1.pays.limit.storage;

import com.example.home1.pays.limit.model.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitStorage extends JpaRepository<Limit, Long> {

}
