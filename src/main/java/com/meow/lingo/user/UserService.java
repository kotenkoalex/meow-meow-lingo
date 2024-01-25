package com.meow.lingo.user;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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

    public AppUser getCurrentUser(String email) {
        return userDao
                .findByEmail(email)
                .orElseThrow(NoSuchElementException::new);
    }
}
