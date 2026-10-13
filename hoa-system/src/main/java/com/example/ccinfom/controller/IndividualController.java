package com.example.ccinfom.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ccinfom.service.IndividualService;
import com.example.ccinfom.model.Individual;

import java.util.List;

@RestController
@RequestMapping("/individuals")
public class IndividualController {

    private final IndividualService individualService;

    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }

    @GetMapping
    public List<Individual> getAllIndividuals() {
        return individualService.getAllIndividuals();
    }

    @GetMapping("/{id}")
    public Individual getIndividual(@PathVariable int id) {
        return individualService.getIndividualById(id);
    }

    @PostMapping
    public int createIndividual(@RequestBody Individual individual) {
        return individualService.createIndividual(individual);
    }
}
