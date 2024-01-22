package com.meow.lingo.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Deprecated(since = "remove after testing")
    public void fillDB() {
        if (userDao.findAll().size() == 0) {
            userDao.save(new AppUser(
                    "Alex",
                    "Kotenko",
                    "test@gmail.com",
                    "password"
            ));
        }
    }
}
