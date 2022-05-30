package com.generation.model;

import java.util.List;

public interface Evaluation {

    List<Course> findPassedCourses();

    // use CourseGrade instead of Course so that individual course grade can be captured paring with course
    List<CourseGrade> getEnrolledCourses();
}
