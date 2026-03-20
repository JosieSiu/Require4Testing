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

##TestCase
    @Entity
public class TestCase {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    private Requirement requirement;
}

##TestRun
    @Entity
public class TestRun {

    @Id @GeneratedValue
    private Long id;

    private String name;
}

##TextEcecution
    @Entity
public class TestExecution {

    @Id @GeneratedValue
    private Long id;

    private String testerName;
    private String result;

    @ManyToOne
    private TestCase testCase;

    @ManyToOne
    private TestRun testRun;
}
