package com.example.ccinfom.controller;

import com.example.ccinfom.model.Asset;
import com.example.ccinfom.service.AssetService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public List<Asset> getAll() {
        return assetService.getAllAssets();
    }

    @GetMapping("/{id}")
    public Asset getById(@PathVariable int id) {
        return assetService.getAssetById(id);
    }

    @PostMapping
    public int create(@RequestBody Asset asset) {
        return assetService.createAsset(asset);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id) {
        return assetService.deleteAsset(id);
    }
}