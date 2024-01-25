package com.meow.lingo.lesson;

import com.meow.lingo.user.AppUser;
import com.meow.lingo.user.UserDao;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class LessonService {
    private final LessonDao lessonDao;
    private final UserDao userDao;

    public LessonService(LessonDao lessonDao, UserDao userDao) {
        this.lessonDao = lessonDao;
        this.userDao = userDao;
    }

    public Lesson createLesson(AppUser user) {
        Lesson lesson = new Lesson(
                false,
                user,
                Timestamp.from(Instant.now()),
                null);
        return lessonDao.save(lesson);
    }
}
