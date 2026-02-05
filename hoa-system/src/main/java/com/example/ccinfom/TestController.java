package com.example.ccinfom;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/homeowners")
public class TestController {

    private final HoaService hoaService;

    public TestController(HoaService hoaService) {
        this.hoaService = hoaService;
    }

    @PostMapping
    public Homeowner create(@RequestBody Homeowner homeowner) {
        return hoaService.save(homeowner);
    }

    @GetMapping("/{id}")
    public Homeowner get(@PathVariable Long id) {
        return hoaService.findById(id);
    }

}
