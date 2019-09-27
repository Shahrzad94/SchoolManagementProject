package se.shjava.shahrzad.data;

import se.shjava.shahrzad.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {

    private List<Course> listOfCourses= new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
        if(!listOfCourses.contains(course)){
            listOfCourses.add(course);
            System.out.println("Course name : " + course.getCourseName()+ " , " + " is added!");
            return course;
        }
        return null;
    }

    @Override
    public Course findById(int id) {
        for (Course course: listOfCourses){
            if(course.getCourseId()== id){
                return course;
            }
        }
        return null;
    }
    @Override
    public List<Course> findByName(String name) {
        List<Course> courseList= new ArrayList<>();
        for (Course course: courseList){
            if (course.getCourseName().equalsIgnoreCase(name)){
                courseList.add(course);
                return courseList;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> courseList= new ArrayList<>();
        for (Course course: courseList){
            if (course.getStartDate().isEqual(date)){
                courseList.add(course);

            }
        }
        return courseList;
    }

    @Override
    public List<Course> findAll() {
        System.out.println(" Courses are found !");
        return listOfCourses;
    }

    @Override
    public boolean removeCourse(Course course) {
        if (listOfCourses.contains(course)){
            listOfCourses.remove(course);
            System.out.println("Course name :" + " " + course.getCourseName() + " , " + "is deleted");
            return true;
        }
        return false;
    }
}
