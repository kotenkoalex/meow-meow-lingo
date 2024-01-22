package com.meow.lingo.learning;

import com.meow.lingo.directobject.DirectObject;
import com.meow.lingo.lesson.Lesson;
import com.meow.lingo.verb.Verb;
import com.meow.lingo.user.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "verb_id")
    private Verb verb;
    @ManyToOne
    @JoinColumn(name = "direct_object_id")
    private DirectObject directObject;
    private int verbAttempts;
    private int directObjectVocabularyAttempts;
    private boolean learningStatus;
    private boolean incorrectData;

    public Learning(Lesson lesson, AppUser appUser, Verb verb, DirectObject directObject, int verbAttempts, int directObjectVocabularyAttempts, boolean learningStatus, boolean incorrectData) {
        this.lesson = lesson;
        this.appUser = appUser;
        this.verb = verb;
        this.directObject = directObject;
        this.verbAttempts = verbAttempts;
        this.directObjectVocabularyAttempts = directObjectVocabularyAttempts;
        this.learningStatus = learningStatus;
        this.incorrectData = incorrectData;
    }
}
