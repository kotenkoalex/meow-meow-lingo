package com.meow.lingo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Verb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String verb;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "direct_object_id")
    private DirectObject directObject;
    private String translateVerb;
    private boolean incorrectData;
}
