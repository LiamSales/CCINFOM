package com.example.ccinfom.controller;

import com.example.ccinfom.model.Property;
import com.example.ccinfom.service.PropertyService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<Property> getAll() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{code}")
    public Property getOne(@PathVariable String code) {
        return propertyService.getProperty(code);
    }

    @PostMapping
    public int create(@RequestBody Property property) {
        return propertyService.createProperty(property);
    }

    @DeleteMapping("/{code}")
    public int delete(@PathVariable String code) {
        return propertyService.deleteProperty(code);
    }
}
