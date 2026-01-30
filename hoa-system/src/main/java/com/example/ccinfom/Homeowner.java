package com.example.ccinfom;

public class Homeowner {

    private Long id;
    private String name;

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
