package LMS.service;

import LMS.models.Group;
import LMS.models.Lesson;

import java.util.List;

public interface LessonService {
    void addLesson(String nameGroup,Lesson lesson);

    void getLessonByName(String groupName);

    void getAllLesson(String name);

    void deleteLesson(Long id);

}
