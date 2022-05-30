package com.generation.service;

import com.generation.model.CourseGrade;
import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student ) {
        //TODO
        students.put(student.getId(), student); // create new student
    }

    public Student findStudent( String studentId ) {
        //TODO
        if (students.containsKey( studentId )) {
            return students.get(studentId); // return student object when found
        }
        return null;
    }

    public boolean showSummary() {
        //TODO
        if (students.size() == 0) {
            return false;
        }
        for (Student s: students.values()) { // display all student records
            System.out.println(s);
            List<CourseGrade> courseList = s.getEnrolledCourses();
            if (courseList.size() > 0) {
                System.out.println("Enrolled Courses:");
                for (CourseGrade c : courseList) { // display all the courses student is enrolled to
                    System.out.println(c);
                }
            }
            else {
                System.out.println("Enrolled Courses: None.");
            }
            System.out.println("*** *** *** *** *** *** *** ***"); // insert line separator after each student's data for clarity
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
