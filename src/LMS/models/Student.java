package LMS.models;

import LMS.enam.Gender;
import LMS.enam.Role;

import java.util.List;

public class Student {
    private Long id;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private Gender gender;
    private Role role;

    private static long generateId = 1;

    public Student() {
        this.id=generateId++;
    }

    public Student(String firstName, String lastName, String email, String password, Gender gender, Role role) {
        this.id=generateId++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "            Student\n" +
                "id          : " + id +"\n"+
                " firstName=   " + firstName + '\n' +
                " lastName=    " + lastName + '\n' +
                " email=       " + email + '\n' +
                " password=    " + password + '\n' +
                " gender=      " + gender +
                "\n";
    }
}
