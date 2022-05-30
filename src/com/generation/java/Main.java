package com.generation.java;

import com.generation.model.Course;
import com.generation.model.CourseGrade;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
            throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    private static void enrollCourse( StudentService studentService, CourseService courseService, Scanner scanner ) {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null ) {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID (NOT CASE SENSITIVE)" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId.toUpperCase() );
        if ( course == null ) {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        if (!studentService.showSummary())
        {
            System.out.println("No Student Yet");
        }
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {

        Student student = getStudentInformation( studentService, scanner );
//        System.out.println( "Enrolled course:" );
        //TODO
        if (student != null) {
            System.out.println(student);
            List<CourseGrade> courseList = student.getEnrolledCourses();
            if (courseList.size() > 0) {
                System.out.println("Enrolled Courses:"); // display all the courses student enrolled to
                for (CourseGrade c : courseList)
                    System.out.println(c);
            } else {
                System.out.println("There are NO Course(s) available for grading.");
                return;
            }

            // accept user's input for the course to be graded
            System.out.println("Insert course ID to be graded (NOT CASE SENSITIVE)");
            String courseId = scanner.next();
            CourseGrade course = student.findCourseById( courseId.toUpperCase() );
            if ( course == null ) {
                System.out.println( "Course ID Not Found!" );
                return;
            }

            // accept user's input for the grade
            double grade = 0;
            do {
                try {
                    System.out.println("Insert course grade (between 1.00 and 6.00) for:" + course.getCourse().getName());
                    grade = Double.parseDouble(scanner.next());
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid value, enter a numeric value between 1.00 and 6.00");
                }
            } while ( ! (grade >= 1 && grade <= 6) ); // loop until user enters bet 1 and 6
            course.setGrade(grade);
        }
    }

    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner ) throws ParseException {
       Student student = PrinterHelper.createStudentMenu( scanner );
       studentService.subscribeStudent( student );
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        else
        {
            List<Course> cl = student.findPassedCourses();
            if ( cl.size() == 0)
            {
                System.out.println( "No passed courses available" );
            }
           else
            {
                System.out.println("Courses with grades >= 3.0");
                for( Course c: cl ) { // loop trough to print out nicely instate of [arraylist] result
                    System.out.println(c);
                }
            }
        }
    }
}
