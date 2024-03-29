package com.meow.lingo.lesson;

import com.meow.lingo.user.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private boolean lessonStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
    private Timestamp createdAt;
    private Timestamp learnedAt;

    public Lesson(boolean lessonStatus, AppUser appUser, Timestamp createdAt, Timestamp learnedAt) {
        this.lessonStatus = lessonStatus;
        this.appUser = appUser;
        this.createdAt = createdAt;
        this.learnedAt = learnedAt;
    }
}
