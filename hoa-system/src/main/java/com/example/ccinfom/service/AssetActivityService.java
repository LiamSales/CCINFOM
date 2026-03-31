package com.example.ccinfom.service;

import com.example.ccinfom.dao.AssetActivityDao;
import com.example.ccinfom.model.AssetActivity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetActivityService {

    private final AssetActivityDao dao;

    public AssetActivityService(AssetActivityDao dao) {
        this.dao = dao;
    }

    public List<AssetActivity> getAll() {
        return dao.findAll();
    }

    public int create(AssetActivity activity) {
        return dao.insert(activity);
    }
}