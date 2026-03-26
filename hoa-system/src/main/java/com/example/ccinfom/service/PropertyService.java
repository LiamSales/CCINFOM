package com.example.ccinfom.service;

import com.example.ccinfom.dao.HomeownerDao;
import com.example.ccinfom.dao.PropertyDao;
import com.example.ccinfom.model.Homeowner;
import com.example.ccinfom.model.Property;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    private final PropertyDao propertyDao;
    private final HomeownerDao homeownerDao;

    public PropertyService(PropertyDao propertyDao,
                           HomeownerDao homeownerDao) {
        this.propertyDao = propertyDao;
        this.homeownerDao = homeownerDao;
    }

    public List<Property> getAllProperties() {
        return propertyDao.findAll();
    }

    public Property getProperty(String propertycode) {
        return propertyDao.findById(propertycode);
    }

    public int createProperty(Property property) {

        // BUSINESS RULE:
        // Property must belong to an existing homeowner

        Homeowner homeowner = homeownerDao.findById(property.getHomeownerid());

        if (homeowner == null) {
            throw new IllegalStateException("Homeowner must exist before property assignment");
        }

        return propertyDao.insert(property);
    }

    public int deleteProperty(String propertycode) {
        return propertyDao.delete(propertycode);
    }
}
