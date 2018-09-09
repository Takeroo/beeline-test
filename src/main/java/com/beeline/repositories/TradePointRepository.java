package com.beeline.repositories;

import com.beeline.models.Company;
import com.beeline.models.TradePoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TradePointRepository extends JpaRepository<TradePoint, Integer> {
    Collection<TradePoint> findByUserId(Integer userId);
}
