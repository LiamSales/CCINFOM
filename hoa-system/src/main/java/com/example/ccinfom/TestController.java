package com.example.ccinfom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
  //“This class contains HTTP endpoints.”
public class TestController {

  //When an HTTP GET request arrives for /, call this method
    @GetMapping("/")
    public String home() {
        return "HOA system is alive";
    }
}
