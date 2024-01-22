package com.meow.lingo.directobject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DirectObjectDao extends JpaRepository<DirectObject, UUID> {
    List<DirectObject> findByDirectObjectVocabularyAndDirectObjectExtra(String directObjectVocabulary, String directObjectExtra);
}
