package com.meow.lingo.verb;

import org.springframework.stereotype.Service;

@Service
public class VerbService {
    private final VerbDao verbDao;

    public VerbService(VerbDao verbDao) {
        this.verbDao = verbDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (verbDao.findAll().size() == 0) {
            verbDao.saveAll();
        }
    }
}
