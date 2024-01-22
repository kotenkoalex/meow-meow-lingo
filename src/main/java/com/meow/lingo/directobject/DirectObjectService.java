package com.meow.lingo.directobject;

import com.meow.lingo.utils.ReaderTestData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirectObjectService {
    private final DirectObjectDao directObjectDao;

    public DirectObjectService(DirectObjectDao directObjectDao) {
        this.directObjectDao = directObjectDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (directObjectDao.findAll().size() == 0) {
            List<String> lines = ReaderTestData.readData();
            List<DirectObject> directObjects = new ArrayList<>();
            for (String line : lines) {
                String[] split = line.split("\\*");
                String directObjectVocabulary = split[4];
                String translateDirectObjectVocabulary = split[5];
                String directObjectExtra = split[6];
                String translateDirectObjectExtra = split[7];
                DirectObject directObject = new DirectObject(
                        directObjectVocabulary,
                        directObjectExtra,
                        translateDirectObjectVocabulary,
                        translateDirectObjectExtra,
                        false
                );
                directObjects.add(directObject);
            }
            directObjectDao.saveAll(directObjects);
        }
    }
}
