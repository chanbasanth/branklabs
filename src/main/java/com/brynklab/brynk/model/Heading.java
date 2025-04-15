package com.brynklab.brynk.model;

import jakarta.persistence.*;

@Entity
public class Heading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String content;

    public Heading() {}
    public Heading(String content) {
        this.content = content;
    }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
