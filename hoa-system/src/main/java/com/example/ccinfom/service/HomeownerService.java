package com.example.ccinfom.service;

import com.example.ccinfom.dao.HomeownerDao;
import com.example.ccinfom.dao.IndividualDao;
import com.example.ccinfom.model.Homeowner;
import com.example.ccinfom.model.Individual;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeownerService {

    private final HomeownerDao homeownerDao;
    private final IndividualDao individualDao;

    public HomeownerService(HomeownerDao homeownerDao,
                            IndividualDao individualDao) {
        this.homeownerDao = homeownerDao;
        this.individualDao = individualDao;
    }

    public List<Homeowner> getAllHomeowners() {
        return homeownerDao.findAll();
    }

    public Homeowner getHomeownerById(int homeownerid) {
        return homeownerDao.findById(homeownerid);
    }

    public int createHomeowner(Homeowner homeowner) {

        // Business rule:
        // homeowner must already exist as an Individual

        Individual individual = individualDao.findById(homeowner.getHomeownerid());

        if (individual == null) {
            throw new IllegalStateException("Individual must exist before becoming a homeowner");
        }

        return homeownerDao.insert(homeowner);
    }

    public int deleteHomeowner(int homeownerid) {
        return homeownerDao.delete(homeownerid);
    }
}