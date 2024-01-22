package com.meow.lingo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserDao extends JpaRepository<AppUser, UUID> {
}