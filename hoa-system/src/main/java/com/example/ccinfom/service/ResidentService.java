package com.example.ccinfom.service;

import com.example.ccinfom.dao.ResidentDao;
import com.example.ccinfom.dao.IndividualDao;
import com.example.ccinfom.model.Resident;
import com.example.ccinfom.model.Individual;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentService {

    private final ResidentDao residentDao;
    private final IndividualDao individualDao;

    public ResidentService(ResidentDao residentDao,
                           IndividualDao individualDao) {
        this.residentDao = residentDao;
        this.individualDao = individualDao;
    }

    public List<Resident> getAllResidents() {
        return residentDao.findAll();
    }

    public Resident getResidentById(int residentid) {
        return residentDao.findById(residentid);
    }

    public int createResident(Resident resident) {

        // Business rule:
        // resident must exist in individual table

        Individual individual = individualDao.findById(resident.getResidentid());

        if (individual == null) {
            throw new IllegalStateException("Individual must exist before becoming a resident");
        }

        return residentDao.insert(resident);
    }

    public int deleteResident(int residentid) {
        return residentDao.delete(residentid);
    }
}
