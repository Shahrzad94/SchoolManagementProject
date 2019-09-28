package se.shjava.shahrzad.data;

import org.junit.Before;
import org.junit.Test;
import se.shjava.shahrzad.model.Student;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentDaoListTest {
    private StudentDaoList testStudentDaoListObj;
    private Student testStudents;
    private Student testNewStudent;

    @Before
    public void init(){
        testStudents= new Student(1, "test", "test@test.com", "addresstest");
        testNewStudent= new Student(20, "shahrzad", "sh@gmail.com", "Campustest");

        testStudentDaoListObj=new StudentDaoList();
    }

    @Test
    public void saveStudent_test(){
     Student expected= testStudents;
     Student actual= testStudentDaoListObj.saveStudent(testStudents);
     assertEquals(expected,actual);
     actual=testStudentDaoListObj.saveStudent(testStudents);
     assertEquals(null, actual);
    }

    @Test
    public void test_Find_Student_byEmail(){
    testStudentDaoListObj.saveStudent(testStudents);
    Student expected= testStudents;
    Student actual= testStudentDaoListObj.findByEmail("test@test.com");
    assertEquals(expected,actual);
    }

    @Test
    public void check_noneExistedEmail_findByEmail_return_null(){
        assertNull(testStudentDaoListObj.findByEmail("st@email.com"));
    }
    @Test
    public void send_nonexistenceId_findById_return_null(){
        assertNull(testStudentDaoListObj.findById(3));
    }
    @Test
    public void test_removeStudent(){
        testStudentDaoListObj.saveStudent(testStudents);
        assertEquals(true,testStudentDaoListObj.deleteStudent(testStudents));
        assertEquals(false,testStudentDaoListObj.deleteStudent(testStudents));
    }
    @Test
    public void test_Find_Student_byId()
    {
        testStudentDaoListObj.saveStudent(testStudents);
        Student excepted= testStudents;
        Student actual= testStudentDaoListObj.findById(20);
      //  assertEquals(excepted, actual);
       actual= testStudentDaoListObj.findById(30);
       assertEquals(null, actual);
    }

    @Test
    public void test_Find_Student_byName(){


    }



}






