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
    private Student testStudent1;



    private Student[] data(){
        Student[] students= {
                new Student(1,"w", "ww", "wwww")
        };
        return students;
    }

    @Before
    public void init(){
        testStudent1= new Student(1, "test", "test@test.com", "addresstest");
       // testNewStudent= new Student(20, "shahrzad", "sh@gmail.com", "Campustest");

        testStudentDaoListObj=new StudentDaoList();
    }

    @Test
    public void saveStudent_test(){
     Student expected= testStudent1;
     Student actual= testStudentDaoListObj.saveStudent(testStudent1);
     assertEquals(expected,actual);
     actual=testStudentDaoListObj.saveStudent(testStudent1);
     assertEquals(null, actual);
    }

    @Test
    public void test_Find_Student_byEmail(){
    testStudentDaoListObj.saveStudent(testStudent1);
    Student expected= testStudent1;
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
        testStudentDaoListObj.saveStudent(testStudent1);
        assertEquals(true,testStudentDaoListObj.deleteStudent(testStudent1));
        assertEquals(false,testStudentDaoListObj.deleteStudent(testStudent1));
    }
    @Test
    public void test_Find_Student_byId()
    {
        testStudentDaoListObj.saveStudent(testStudent1);
        Student excepted= testStudent1;
        Student actual= testStudentDaoListObj.findById(1);
        assertEquals(excepted, actual);                    //oops
    }

    @Test
    public void test_Find_Student_byName(){
    List<Student> expected= new ArrayList<>();
    expected.add(testStudent1);
    testStudentDaoListObj.saveStudent(testStudent1);

    List<Student> actual= testStudentDaoListObj.findByName("test");
    assertEquals(expected, actual);


    }



}






