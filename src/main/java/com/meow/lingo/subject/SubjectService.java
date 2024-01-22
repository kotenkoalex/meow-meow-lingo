package com.meow.lingo.subject;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (subjectDao.findAll().size() == 0) {
            List<Subject> subjects = List.of(
                    new Subject("Je", "Я"),
                    new Subject("Tu", "Ти"),
                    new Subject("Il", "Він"),
                    new Subject("Elle", "Вона"),
                    new Subject("On", "Вони"),
                    new Subject("Nous", "Ми"),
                    new Subject("Vous", "Ви"),
                    new Subject("Ils", "Вони"),
                    new Subject("Elles", "Вони")
            );
            subjectDao.saveAll(subjects);
        }
    }
}
