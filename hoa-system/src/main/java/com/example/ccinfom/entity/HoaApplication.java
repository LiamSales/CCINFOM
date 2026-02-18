package com.example.ccinfom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Enables component scanning
//Enables auto-configuration
//Marks this class as the application root


@SpringBootApplication
public class HoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaApplication.class, args);

        //Boots the Spring container
        //Starts embedded Tomcat
        //Opens port 8080
        //Wires all controllers and beans
        
    }
}
