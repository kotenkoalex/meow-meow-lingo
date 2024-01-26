package com.meow.lingo;

import com.meow.lingo.learning.Learning;
import com.meow.lingo.learning.LearningService;
import com.meow.lingo.lesson.Lesson;
import com.meow.lingo.lesson.LessonService;
import com.meow.lingo.user.UserService;

import java.util.List;

public class AppService {
    private final LessonService lessonService;
    private final UserService userService;

    private final LearningService learningService;

    public AppService(LessonService lessonService, UserService userService, LearningService learningService) {
        this.lessonService = lessonService;
        this.userService = userService;
        this.learningService = learningService;
    }

    public void learning() {
        Lesson lesson = lessonService.createLesson(userService.getCurrentUser("test@gmail.com"));
        List<Learning> learnings = learningService.startLearning();
    }

    //create a lesson
    //take 10 sentences (based on algorithm)
    //initiate learning + keep result (make it in console)
    //finish learning
    //start new lesson
}
