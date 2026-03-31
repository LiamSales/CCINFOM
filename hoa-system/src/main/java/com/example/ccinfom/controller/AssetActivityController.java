package com.example.ccinfom.controller;

import com.example.ccinfom.model.AssetActivity;
import com.example.ccinfom.service.AssetActivityService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class AssetActivityController {

    private final AssetActivityService service;

    public AssetActivityController(AssetActivityService service) {
        this.service = service;
    }

    @GetMapping
    public List<AssetActivity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public int create(@RequestBody AssetActivity activity) {
        return service.create(activity);
    }
}