package com.example.ccinfom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity
@Inheritance(strategy = JOINED)
public class Individual{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int individualid;
    
    @NotBlank
    @Column(length = 45)
    private String lastname;

    @Column(length = 45)
    private String firstname;

    @Column(length = 45)
    private String mi;

    @NotBlank
    @Past
    private LocalDate birthday;

    @Enumerated(EnumType.CHAR)
    private Gender gender;

    @Email
    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String facebook_url;

    @Column(length = 45)
    private String pic_filename;

    //set null to false
    private boolean undertaking;
}