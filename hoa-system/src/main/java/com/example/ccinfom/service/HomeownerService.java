package com.example.ccinfom;

import org.springframework.stereotype.Service;

//we also need to edit this because its basically an inheritance, so we inherit from individual again? i think?


@Service
public class HomeownerService {

    private final HomeownerRepository homeownerRepository;

    public HomeownerService(HomeownerRepository homeownerRepository) {
        this.homeownerRepository = homeownerRepository;
    }

    public Homeowner save(Homeowner homeowner) {
        return homeownerRepository.save(homeowner);
    }

    public Homeowner findById(Long id) {
    return homeownerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Homeowner not found: " + id));
}

    public Homeowner getSampleHomeowner() {
        return homeownerRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Homeowner not found"));
    }

    // should also have sql commands for other tables
}
