package com.generation.model;

// create this class to hold course information and its corresponding grade value
// so that each student will have their own individual grade based on the course they enrolled
public class CourseGrade {
    Course course;
    double grade;

    public CourseGrade(Course course) {
        this.course = course;
        this.grade = 0;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        // calling course will result in course.toString()
        return course + " Grade: " + String.format("%.2f", grade);
    }
}
