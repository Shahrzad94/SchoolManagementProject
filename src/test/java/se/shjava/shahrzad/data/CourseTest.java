package se.shjava.shahrzad.data;

import org.junit.Before;
import org.junit.Test;
import se.shjava.shahrzad.model.Course;
import se.shjava.shahrzad.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CourseTest {

    private Course courseTest1;
    private CourseDaoList courseDaoListTest;
    private Student studentTest;
    private StudentDaoList studentDaoListTest;




    @Before
    public void init(){
        courseTest1= new Course(1," Test", LocalDate.parse("2019-09-30"), 6);
        studentTest= new Student(12, "Test student1", "st@gmail.com", " PG street");
        courseDaoListTest= new CourseDaoList();
        studentDaoListTest= new StudentDaoList();
    }


    @Test
    public void test_register_student(){
        List<Student> expectedStudentList= new ArrayList<>();
        expectedStudentList.add(studentTest);
        courseTest1.registerStudents(studentTest);
        assertEquals(expectedStudentList, courseTest1.getListOfStudents());

    }

    @Test
    public void test_remove_student_from_course(){
        List<Student> expectedRemovingList= new ArrayList<>();
        expectedRemovingList.remove(studentTest);
        courseTest1.removeStudent(studentTest);
        assertEquals(expectedRemovingList, courseTest1.getListOfStudents());
    }

}
