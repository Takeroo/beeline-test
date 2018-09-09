package com.beeline.services;

import com.beeline.models.TradePoint;
import com.beeline.models.User;
import com.beeline.repositories.TradePointRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TradePointServiceImpl implements TradePointService{

    private final TradePointRepository tradePointRepository;

    public TradePointServiceImpl(TradePointRepository tradePointRepository){
        this.tradePointRepository = tradePointRepository;
    }

    @Override
    public Collection<TradePoint> findAll() {
        return tradePointRepository.findAll();
    }

    @Override
    public TradePoint findOne(Integer id) {
        return tradePointRepository.findOne(id);
    }

    @Override
    public TradePoint save(TradePoint tradePoint) {
        return tradePointRepository.save(tradePoint);
    }

    @Override
    public TradePoint update(Integer id, TradePoint tradePoint, Boolean isAdmin) {
        TradePoint toBeUpdated = findOne(id);
        if (toBeUpdated == null) {
            throw new RuntimeException("TradePoint not found");
        }
        if(isAdmin) BeanUtils.copyProperties(tradePoint, toBeUpdated, "id", "companyId");
        else BeanUtils.copyProperties(tradePoint, toBeUpdated, "id", "companyId", "userId");
        return toBeUpdated;
    }

    @Override
    public void delete(Integer id) {
        TradePoint tradePoint = findOne(id);
        if (tradePoint != null) {
            tradePointRepository.delete(tradePoint);
        }
    }

    @Override
    public Collection<TradePoint> getByUser(User currenUser) {
        return tradePointRepository.findByUserId(currenUser.getId());
    }
}
