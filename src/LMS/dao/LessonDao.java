package LMS.dao;

import LMS.models.Group;
import LMS.models.Lesson;

import java.util.List;

public interface LessonDao {
    void addLesson(String nameGroup,Lesson lesson);

    void getLessonByName(String name);

    void getAllLesson(String groupName);

    void deleteLesson(Long id);
}
