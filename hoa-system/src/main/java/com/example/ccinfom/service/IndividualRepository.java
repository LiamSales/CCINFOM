package com.example.ccinfom.service;

import com.example.ccinfom.dao.IndividualDao;
import com.example.ccinfom.model.Individual;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualService {

    private final IndividualDao individualDao;

    public IndividualService(IndividualDao individualDao) {
        this.individualDao = individualDao;
    }

    public List<Individual> getAllIndividuals() {
        return individualDao.findAll();
    }

    public Individual getIndividualById(int individualid) {
        return individualDao.findById(individualid);
    }

    public int createIndividual(Individual individual) {

        // Example business rule:
        // email must not be empty
        if (individual.getEmail() == null || individual.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        return individualDao.insert(individual);
    }

    public int deleteIndividual(int individualid) {
        return individualDao.delete(individualid);
    }
}