package se.shjava.shahrzad.data.model;

import org.junit.Before;
import org.junit.Test;
import se.shjava.shahrzad.model.Course;
import se.shjava.shahrzad.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCourse {
    private Course testObject;
   private Student testObjectStudent;


    @Before
    public void init(){
        testObjectStudent= new Student(1, "test", "test@test.com", "testAddress");
        testObject= new Course(88, "Test Course", LocalDate.parse("2019-09-30"), 5);
    }



}
