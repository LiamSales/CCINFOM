package com.example.ccinfom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final HoaService hoaService;

    public TestController(HoaService hoaService) {
        this.hoaService = hoaService;
    }

    @GetMapping("/")
    public String home() {
        return hoaService.getStatus();
    }
}
