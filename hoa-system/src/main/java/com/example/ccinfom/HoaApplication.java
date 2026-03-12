package com.example.ccinfom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication does three things:

1. Enables component scanning
   Spring searches this package and all subpackages for beans.

2. Enables auto-configuration
   Spring Boot automatically configures things like:
   - DataSource
   - JdbcTemplate
   - embedded server

3. Marks this as the application root.
*/

@SpringBootApplication
public class HoaApplication {

    public static void main(String[] args) {

        SpringApplication.run(HoaApplication.class, args);

        /*
        This boots the Spring Boot runtime.

        Internally it will:
        - create the Spring container
        - scan packages for components
        - configure beans automatically
        - start the embedded web server (usually Tomcat)
        - bind the server to port 8080 unless changed in application.properties
        */
    }
}