package se.shjava.shahrzad.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.shjava.shahrzad.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class CourseDaoListTest {

    private CourseDaoList testCourseDaoList;
    private Course testCourse1;
    private Course testCourse2;
    private StudentDaoList testStudentDaoList;


    @Before
    public void init(){
      testCourse1= new Course(88, "Test88", LocalDate.parse("2019-10-30"), 6);
      testCourse2= new Course(99, "Test99", LocalDate.parse("2019-10-20"), 5);
      testCourseDaoList= new CourseDaoList();
      testStudentDaoList= new StudentDaoList();
    }

    @Test
    public void test_give_NotExistingCourseId(){
        assertNull(testCourseDaoList.findById(89));
    }

    @Test
    public void test_SaveCourse(){
        Course expected = testCourse1;
        Course actual = testCourseDaoList.saveCourse(testCourse1);
        assertEquals(expected,actual);
        actual = testCourseDaoList.saveCourse(testCourse1);
        assertEquals(null,actual);
    }

    @Test
    public void test_findAll_Courses(){
        List<Course> expected = new ArrayList<>();
        expected.add(testCourse1);
        testCourseDaoList.saveCourse(testCourse1);
        assertEquals(expected,testCourseDaoList.findAll());
    }
    @Test
    public void test_Remove_Course(){
        testCourseDaoList.saveCourse(testCourse1);
        assertEquals(true,testCourseDaoList.removeCourse(testCourse1));
        assertEquals(false,testCourseDaoList.removeCourse(testCourse1));
    }

    @Test
    public void test_Find_Course_by_Name(){                   //problem (Assert.java:743)
        List<Course> expected = new ArrayList<>();
        expected.add(testCourse1);
        testCourseDaoList.saveCourse(testCourse1);
        Assert.assertEquals(expected, testCourseDaoList.findByName("Test88"));
    }

    @Test
    public void test_Find_Course_by_Date(){
        List<Course> expected= new ArrayList<>();
        expected.add(testCourse1);
        testCourseDaoList.saveCourse(testCourse1);
      assertEquals(expected, testCourseDaoList.findByDate(LocalDate.parse("2019-10-30")));


   }
   @Test
    public void test_remove_course(){

        List<Course> expected= new ArrayList<>();
        expected.add(testCourse1);
        expected.remove(testCourse1);
   }


}

