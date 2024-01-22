package com.meow.lingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeowMeowLingoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeowMeowLingoApplication.class, args);
    }



    //Subject
    // - id
    // - subject
    // - translate_subject
    //
    //Verb
    // - id
    // - verb
    // - subject_id
    // - direct_object_id
    // - translate_verb
    // - incorrect_data
    //
    //Direct_Object
    // - id
    // - direct_object_vocabulary
    // - direct_object_extra
    // - translate_direct_object_vocabulary
    // - translate_direct_object_extra
    // - incorrect_data
    //
    //Lesson
    // - id
    // - learning_status
    // - user_id
    // - created_at
    // - learned_at
    //
    //Learning
    // - id
    // - lesson_id
    // - verb_id
    // - learning_status
    // - incorrect_data
    //
    //User
    // - id
    // - first_name
    // - last_name
    // - email
    // - password
    //
    //Verb_Attempts
    // - user_id
    // - verb_id
    // - attempts_verb
    //
    //Direct_Object_Attempts
    // - user_id
    // - direct_object_id
    // - attempts_direct_object

    // ** smart ideas
    //1. **Verb_Attempts + Direct_Object_Attempts as separate tables to track progress, and for Subject, this is not needed because it is either a name or a pronoun, so there is no sense in training it separately:**
    //
    //2. **The Learning table is dynamic; the idea is that for each lesson, new rows will be created for each user. If the lesson is completed, unnecessary rows will be deleted. Consider optimization when working simultaneously with multiple users:**
    //
    //3. **Added the flag incorrect_data, so if something is wrong with the data, do not consider that specific row in the Learning, Verb, Direct_Object tables (later add a menu where all problematic data can be updated through the web interface):**
}
