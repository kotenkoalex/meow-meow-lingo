package com.meow.lingo.learning;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearningDao extends JpaRepository<Learning, UUID> {
}
