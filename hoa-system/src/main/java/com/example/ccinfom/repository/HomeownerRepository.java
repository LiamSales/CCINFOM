package com.example.ccinfom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeownerRepository extends JpaRepository<Homeowner, Long> {
}

// i need to make an interface for everything, a repository for all, maybe we can consolidate into a single file?

