package com.meow.lingo.lesson;

import com.meow.lingo.user.UserDao;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.NoSuchElementException;

@Service
public class LessonService {
    private final LessonDao lessonDao;
    private final UserDao userDao;

    public LessonService(LessonDao lessonDao, UserDao userDao) {
        this.lessonDao = lessonDao;
        this.userDao = userDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (lessonDao.findAll().size() == 0) {
            Lesson lesson = new Lesson(
                    false,
                    userDao.findByEmail("test@gmail.com").orElseThrow(NoSuchElementException::new),
                    Timestamp.from(Instant.now()),
                    null);
            lessonDao.save(lesson);
        }
    }
}
