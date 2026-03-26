package com.example.ccinfom.controller;

import com.example.ccinfom.model.Resident;
import com.example.ccinfom.service.ResidentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    // GET /residents
    @GetMapping
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    // GET /residents/{id}
    @GetMapping("/{id}")
    public Resident getResidentById(@PathVariable int id) {
        return residentService.getResidentById(id);
    }

    // POST /residents
    @PostMapping
    public int createResident(@RequestBody Resident resident) {
        return residentService.createResident(resident);
    }

    // DELETE /residents/{id}
    @DeleteMapping("/{id}")
    public int deleteResident(@PathVariable int id) {
        return residentService.deleteResident(id);
    }
}
