package com.example.ccinfom;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Homeowner {

    @Id
    private Long id;

    private String name;

    protected Homeowner() {
    }

    public Homeowner(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
