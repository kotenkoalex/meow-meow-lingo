package com.meow.lingo.lesson;

import com.meow.lingo.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LessonDao extends JpaRepository<Lesson, UUID> {
    Optional<Lesson> findByAppUser(AppUser user);
}
