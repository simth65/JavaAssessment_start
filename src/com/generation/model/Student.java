package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person implements Evaluation {

    float PASS_MIN_GRADE = 3.0f;
    HashMap<String, Course> coursesEnrolled; // andrew

    public Student( String id, String name, String email, Date birthDate ) {
        super( id, name, email, birthDate );
        coursesEnrolled = new HashMap<>();
    }

    public void enrollToCourse( Course course ) {
        //TODO
        coursesEnrolled.put(course.getCode(), course);
    }

    @Override
    public List<Course> findPassedCourses() {
        //TODO
        return null;
    }

    public Course findCourseById( String courseId ) {
        //TODO
       return null;
    }

    @Override
    public List<Course> getEnrolledCourses() {
        //TODO
        return new ArrayList<Course>( coursesEnrolled.values() ); // convert Hashmap to List
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
