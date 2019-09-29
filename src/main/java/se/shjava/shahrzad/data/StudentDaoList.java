package se.shjava.shahrzad.data;

import se.shjava.shahrzad.model.Student;

import java.util.*;

public class StudentDaoList implements StudentDao {
    private static List<Student> studentsList= new ArrayList<>();


    @Override
    public Student saveStudent(Student student) {           //tested!
        if(!studentsList.contains(student)){
            studentsList.add(student);
            System.out.println(student.getStudentName() + "  " + " is added!");
            return student;
        }
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student student:studentsList){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> listOfNames= new ArrayList<>();
        for (Student student: listOfNames){
            if (student.getStudentName().equalsIgnoreCase(name)){
              listOfNames.add(student);
            }
        }
        return listOfNames;
    }

    @Override
    public Student findById(int id) {
      for (Student student: studentsList){
          if (student.getStudentId()==id){
              return student;
          }
      }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentsList;
    }

    @Override
    public boolean deleteStudent(Student student) {
       return studentsList.remove(student);
    }


   }