package com.meow.lingo.verb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VerbDao extends JpaRepository<Verb, UUID> {
}
