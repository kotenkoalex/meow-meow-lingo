package com.meow.lingo.directobject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectObjectDao extends JpaRepository<DirectObject, UUID> {
}
