package LMS.dao.impl;

import LMS.config.Validation;
import LMS.dao.StudentDao;
import LMS.dateBase.DateBase;
import LMS.enam.Gender;
import LMS.enam.Role;
import LMS.models.Group;
import LMS.models.Lesson;
import LMS.models.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void savedDefaultAdmin() {
        DateBase.baseStudent.add(new Student("Nursultan", "Dzhuraev",
                "nurs@gmail.com", "nurs123!", Gender.MAN, Role.ADMIN));
    }

    @Override
    public void addStudent(String groupName, Student student) {
        if (!Validation.checkEmail(student.getEmail()) && !Validation.checkPassword(student.getPassword())) {
            System.out.println("invalid email and password ");
        } else {
            for (Group group1 : DateBase.baseGroup) {
                if (group1.getGroupName().equalsIgnoreCase(groupName)) {
                    group1.getStudents().add(student);
                    DateBase.baseStudent.add(student);
                    System.out.println(group1 + "Ийгиликтуу сакталды!");
                    break;
                }
            }
        }
    }


    @Override
    public void updateStudent(String email, String password, Student newStudent) {
        for (Group group : DateBase.baseGroup) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setEmail(newStudent.getEmail());
                    student.setPassword(newStudent.getPassword());
                    student.setGender(newStudent.getGender());
                    student.setId(newStudent.getId());
                    student.setRole(newStudent.getRole());
                    System.out.println("Ийгиликтуу озгорулду!");
                    break;
                }
            }
        }
    }

    @Override
    public void findStudentByFirstName(String name) {
        for (Group group : DateBase.baseGroup) {
            for (Student student : group.getStudents()) {
                if (student.getFirstName().equalsIgnoreCase(name)) {
                    System.out.println(student);
                    break;
                }
            }
        }
    }

    @Override
    public List<Student> getAllStudentByGroupName(String groupName) {

        List<Student> list = new java.util.ArrayList<>(List.of());
        try {
            do for (Group group : DateBase.baseGroup) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    System.out.println(group.getStudents());
                    list.add((Student) group.getStudents());
                    System.out.println(list);
                }
            }
            while (true);
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Lesson> getAllStudentLesson(String email) {
        List<Lesson> listLesson = new java.util.ArrayList<>(List.of());
        for (Group group : DateBase.baseGroup) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equals(email)) {
                    System.out.println(group.getLessons());
                    listLesson.add((Lesson) group.getLessons());
                    System.out.println(listLesson);
                }
            }
        }
        return listLesson;
    }

    @Override
    public void deleteStudent(String email) {
        for (Group group : DateBase.baseGroup) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equals(email)) {
                    group.getStudents().remove(student);
                    System.out.println("Ийгиликтуу очурулду!");
                    break;
                }
            }
        }
    }

    @Override
    public Student singIn(String email, String password) {
        for (Student student : DateBase.baseStudent) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return student;
            }
        }
        throw new RuntimeException("not found");
    }

    @Override
    public void getAllLessonStudents(String email, String password) {
        for (Group group : DateBase.baseGroup) {
            for (Student student : group.getStudents()) {
                if (student.getEmail().equals(email) && student.getPassword().equals(password))
                    System.out.println(group.getLessons());
                break;
            }

        }
    }
}

