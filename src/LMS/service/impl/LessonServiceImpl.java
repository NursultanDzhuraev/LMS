package LMS.service.impl;

import LMS.dao.impl.LessonDaoImpl;

import LMS.models.Lesson;
import LMS.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private final LessonDaoImpl lessonDao;

    public LessonServiceImpl(LessonDaoImpl lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public void addLesson(String nameGroup,Lesson lesson) {
        lessonDao.addLesson(nameGroup,lesson);
    }

    @Override
    public void getLessonByName(String name) {
        lessonDao.getLessonByName(name);
    }

    @Override
    public void getAllLesson(String groupName) {
        lessonDao.getAllLesson(groupName);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonDao.deleteLesson(id);
    }

}
