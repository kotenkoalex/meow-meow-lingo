package com.meow.lingo.subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubjectDao extends JpaRepository<Subject, UUID> {
    Optional<Subject> findBySubject(String subject);
}
