package com.meow.lingo;

import com.meow.lingo.learning.Learning;
import com.meow.lingo.lesson.Lesson;
import com.meow.lingo.lesson.LessonService;
import com.meow.lingo.user.UserService;

public class AppService {
    private final LessonService lessonService;
    private final UserService userService;

    public AppService(LessonService lessonService, UserService userService) {
        this.lessonService = lessonService;
        this.userService = userService;
    }

    public void learning() {
        Lesson lesson = lessonService.createLesson(userService.getCurrentUser("test@gmail.com"));
        Learning learning; //TODO
    }

    //create a lesson
    //take 10 sentences (based on algorithm)
    //initiate learning + keep result (make it in console)
    //finish learning
    //start new lesson
}
