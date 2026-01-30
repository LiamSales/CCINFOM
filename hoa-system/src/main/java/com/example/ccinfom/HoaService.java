package com.example.ccinfom;

import org.springframework.stereotype.Service;

@Service
public class HoaService {

    public String getStatus() {
        return "HOA system is alive (via service)";
    }
}
