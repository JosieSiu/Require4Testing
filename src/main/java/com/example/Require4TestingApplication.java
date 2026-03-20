package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Require4TestingApplication {
    public static void main(String[] args) {
        SpringApplication.run(Require4TestingApplication.class, args);
    }
}

package com.example.model;

import jakarta.persistence.*;

@Entity
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}

package com.example.repository;

import com.example.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}

package com.example.controller;

import com.example.model.Requirement;
import com.example.repository.RequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RequirementController {

    @Autowired
    private RequirementRepository repository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("requirements", repository.findAll());
        return "requirements";
    }

    @PostMapping("/add")
    public String add(Requirement r) {
        repository.save(r);
        return "redirect:/";
    }
}

