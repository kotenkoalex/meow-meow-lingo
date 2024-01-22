package com.meow.lingo.learning;

import com.meow.lingo.directobject.DirectObjectDao;
import com.meow.lingo.lesson.LessonDao;
import com.meow.lingo.user.AppUser;
import com.meow.lingo.user.UserDao;
import com.meow.lingo.utils.ReaderTestData;
import com.meow.lingo.verb.VerbDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LearningService {
    private final LearningDao learningDao;
    private final LessonDao lessonDao;
    private final UserDao userDao;
    private final VerbDao verbDao;
    private final DirectObjectDao directObjectDao;

    public LearningService(LearningDao learningDao, LessonDao lessonDao, UserDao userDao, VerbDao verbDao, DirectObjectDao directObjectDao) {
        this.learningDao = learningDao;
        this.lessonDao = lessonDao;
        this.userDao = userDao;
        this.verbDao = verbDao;
        this.directObjectDao = directObjectDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (learningDao.findAll().size() == 0) {
            List<String> lines = ReaderTestData.readData();
            List<Learning> learnings = new ArrayList<>();
            for (String line : lines) {
                String[] split = line.split("\\*");
                String subject = split[0];
                String verb = split[2];
                String directObjectVocabulary = split[4];
                String directObjectExtra = split[6];
                AppUser user = userDao
                        .findByEmail("test@gmail.com")
                        .orElseThrow(NoSuchElementException::new);
                Learning learning = new Learning(
                        lessonDao
                                .findByAppUser(user)
                                .orElseThrow(NoSuchElementException::new),
                        user,
                        verbDao
                                .findByVerbAndSubjectSubjectAndDirectObjectDirectObjectVocabularyAndDirectObjectDirectObjectExtra(verb, subject, directObjectVocabulary, directObjectExtra)
                                .orElseThrow(NoSuchElementException::new),
                        directObjectDao
                                .findByDirectObjectVocabularyAndDirectObjectExtra(directObjectVocabulary, directObjectExtra)
                                .get(0),
                        0,
                        0,
                        false,
                        false
                );
                learnings.add(learning);
            }
            learningDao.saveAll(learnings);
        }
    }
}
