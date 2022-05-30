package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person implements Evaluation {

    float PASS_MIN_GRADE = 3.0f;
    // defining hashmap of CourseGrade so that individual grading for each course can be captured per student
    HashMap<String, CourseGrade> coursesEnrolled;

    public Student( String id, String name, String email, Date birthDate ) {
        super( id, name, email, birthDate );
        coursesEnrolled = new HashMap<>();
    }

    public void enrollToCourse( Course course ) {
        //TODO
        // using CourseGrade as a class so that grade can be kept corresponding with the Course
        CourseGrade cg = new CourseGrade(course);

        coursesEnrolled.put(course.getCode(), cg);
    }

    @Override
    public List<Course> findPassedCourses() { // change return value to CourseGrade so that grade can be retrieved directly corresponding to the course
        //TODO
        ArrayList<Course> tmpCourseList = new ArrayList<>(); // create list to store course that have grade >= 3.0
        for (CourseGrade cg : coursesEnrolled.values()) {
            if (cg.getGrade() >= PASS_MIN_GRADE) {
                tmpCourseList.add(cg.getCourse());
            }
        }
        return tmpCourseList;
    }

    public CourseGrade findCourseById( String courseId ) { // change return value to CourseGrade so that grade can be updated directly
        //TODO
        if (coursesEnrolled.containsKey(courseId)) {
            return coursesEnrolled.get(courseId);
        }
        return null;
    }

    @Override
    public List<CourseGrade> getEnrolledCourses() {
        //TODO
        return new ArrayList<CourseGrade>( coursesEnrolled.values() ); // convert Hashmap to List
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
