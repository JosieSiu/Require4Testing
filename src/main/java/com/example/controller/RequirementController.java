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
