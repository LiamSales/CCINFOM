package com.example.ccinfom;

import org.springframework.stereotype.Service;

@Service
public class HoaService {

    private final HomeownerRepository homeownerRepository;

    public HoaService(HomeownerRepository homeownerRepository) {
        this.homeownerRepository = homeownerRepository;
    }

    public Homeowner save(Homeowner homeowner) {
        return homeownerRepository.save(homeowner);
    }

    public Homeowner getSampleHomeowner() {
        return homeownerRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Homeowner not found"));
    }
}
