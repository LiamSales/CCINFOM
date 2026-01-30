package com.example.ccinfom;

import org.springframework.stereotype.Repository;

@Repository
public class HomeownerRepository {

    public Homeowner findSample() {
        return new Homeowner(1L, "Juan Dela Cruz");
    }
}
