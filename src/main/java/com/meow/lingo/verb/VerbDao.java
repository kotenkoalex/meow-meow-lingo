package com.meow.lingo.verb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VerbDao extends JpaRepository<Verb, UUID> {
    Optional<Verb> findByVerbAndSubjectSubjectAndDirectObjectDirectObjectVocabularyAndDirectObjectDirectObjectExtra(String verb, String subject, String directObjectVocabulary, String directObjectExtra);
}
