package com.meow.lingo.verb;

import com.meow.lingo.directobject.DirectObjectDao;
import com.meow.lingo.subject.SubjectDao;
import com.meow.lingo.utils.ReaderTestData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VerbService {
    private final VerbDao verbDao;
    private final SubjectDao subjectDao;
    private final DirectObjectDao directObjectDao;

    public VerbService(VerbDao verbDao, SubjectDao subjectDao, DirectObjectDao directObjectDao) {
        this.verbDao = verbDao;
        this.subjectDao = subjectDao;
        this.directObjectDao = directObjectDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (verbDao.findAll().size() == 0) {
            List<String> lines = ReaderTestData.readData();
            List<Verb> verbs = new ArrayList<>();
            for (String line : lines) {
                String[] split = line.split("\\*");
                String subject = split[0];
                String verb = split[2];
                String translateVerb = split[3];
                String directObjectVocabulary = split[4];
                String directObjectExtra = split[6];
                Verb verbEntity = new Verb(
                        verb,
                        subjectDao
                                .findBySubject(subject)
                                .orElseThrow(NoSuchElementException::new),
                        directObjectDao
                                .findByDirectObjectVocabularyAndDirectObjectExtra(directObjectVocabulary, directObjectExtra)
                                .get(0),
                        translateVerb,
                        false
                );
                verbs.add(verbEntity);
            }
            verbDao.saveAll(verbs);
        }
    }
}
