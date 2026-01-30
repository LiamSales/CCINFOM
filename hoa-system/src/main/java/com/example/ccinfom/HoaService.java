package com.example.ccinfom;

import org.springframework.stereotype.Service;

@Service
public class HoaService {

    public Homeowner getSampleHomeowner() {
        return new Homeowner(1L, "Juan Dela Cruz");
    }
}
