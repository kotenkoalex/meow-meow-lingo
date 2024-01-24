package com.meow.lingo;

import com.meow.lingo.directobject.DirectObjectService;
import com.meow.lingo.learning.LearningService;
import com.meow.lingo.lesson.LessonService;
import com.meow.lingo.subject.SubjectService;
import com.meow.lingo.user.UserService;
import com.meow.lingo.verb.VerbService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fill")
public class AppController {
    private final UserService userService;
    private final VerbService verbService;
    private final SubjectService subjectService;
    private final LessonService lessonService;
    private final LearningService learningService;
    private final DirectObjectService directObjectService;

    public AppController(UserService userService,
                         VerbService verbService,
                         SubjectService subjectService,
                         LessonService lessonService,
                         LearningService learningService,
                         DirectObjectService directObjectService) {
        this.userService = userService;
        this.verbService = verbService;
        this.subjectService = subjectService;
        this.lessonService = lessonService;
        this.learningService = learningService;
        this.directObjectService = directObjectService;
    }

    @Deprecated(since = "remove after testing")
    @GetMapping
    public void fillDb() {
        userService.fillDB();
        subjectService.fillDB();
        directObjectService.fillDB();
        verbService.fillDB();
//        lessonService.fillDB(); //this table must have been filled threw app logic
//        learningService.fillDB(); //this table must have been filled threw app logic
    }
}
