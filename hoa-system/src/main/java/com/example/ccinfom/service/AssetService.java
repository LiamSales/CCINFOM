package com.example.ccinfom.service;

import com.example.ccinfom.dao.AssetDao;
import com.example.ccinfom.model.Asset;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetDao assetDao;

    public AssetService(AssetDao assetDao) {
        this.assetDao = assetDao;
    }

    public List<Asset> getAllAssets() {
        return assetDao.findAll();
    }

    public Asset getAssetById(int id) {
        return assetDao.findById(id);
    }

    public int createAsset(Asset asset) {
        return assetDao.insert(asset);
    }

    public int deleteAsset(int id) {
        return assetDao.delete(id);
    }
}