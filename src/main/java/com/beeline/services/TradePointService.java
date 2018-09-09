package com.beeline.services;

import com.beeline.models.TradePoint;
import com.beeline.models.User;

import java.util.Collection;

public interface TradePointService {

    Collection<TradePoint> findAll();

    TradePoint findOne(Integer id);

    TradePoint save(TradePoint tradePoint);

    TradePoint update(Integer id, TradePoint tradePoint, Boolean isAdmin);

    void delete(Integer id);

    Collection<TradePoint> getByUser(User currenUser);
}
