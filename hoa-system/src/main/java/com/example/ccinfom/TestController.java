package com.example.ccinfom;

import org.springframework.web.bind.annotation.*;

@RestController
    //handles HTTP requests and returns JSON
@RequestMapping("/homeowners")
    //sets the base URL path.
public class TestController {

    private final HoaService hoaService;

    public TestController(HoaService hoaService) {
        this.hoaService = hoaService;
    }

    @PostMapping
    //Tomcat receives the HTTP POST
    //passed as an obj in java memory, returned as JSON
    public Homeowner create(@RequestBody Homeowner homeowner) {
        return hoaService.save(homeowner);
    }

    @GetMapping("/{id}")
    public Homeowner get(@PathVariable Long id) {
        return hoaService.findById(id);
    }

}
