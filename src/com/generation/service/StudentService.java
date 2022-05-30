package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student ) {
        //TODO
        students.put(student.getId(), student);
    }

    public Student findStudent( String studentId ) {
        //TODO
        if (students.containsKey( studentId )) {
            return students.get(studentId);
        }
        return null;
    }

    public boolean showSummary() {
        //TODO
        if (students.size() == 0) {
            return false;
        }
        for (Student s: students.values()) {
            System.out.println(s);
            List<Course> courseList = s.getEnrolledCourses();
            if (courseList.size() > 0) {
                System.out.println("Enrolled Courses:");
                for (Course c : courseList)
                    System.out.println(c);
            }
            else {
                System.out.println("Enrolled Courses: None.");
            }
        }
        return true;
    }

    public void enrollToCourse( String studentId, Course course ) {
        //TODO
        if (students.containsKey(studentId)) {
            students.get(studentId).enrollToCourse(course);
        }
    }
}
