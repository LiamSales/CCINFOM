package com.example.ccinfom.controller;

import com.example.ccinfom.model.Homeowner;
import com.example.ccinfom.service.HomeownerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/homeowners")
public class HomeownerController {

    private final HomeownerService homeownerService;

    public HomeownerController(HomeownerService homeownerService) {
        this.homeownerService = homeownerService;
    }

    // GET /homeowners
    @GetMapping
    public List<Homeowner> getAllHomeowners() {
        return homeownerService.getAllHomeowners();
    }

    // GET /homeowners/{id}
    @GetMapping("/{id}")
    public Homeowner getHomeownerById(@PathVariable int id) {
        return homeownerService.getHomeownerById(id);
    }

    // POST /homeowners
    @PostMapping
    public int createHomeowner(@RequestBody Homeowner homeowner) {
        return homeownerService.createHomeowner(homeowner);
    }

    // DELETE /homeowners/{id}
    @DeleteMapping("/{id}")
    public int deleteHomeowner(@PathVariable int id) {
        return homeownerService.deleteHomeowner(id);
    }
}
