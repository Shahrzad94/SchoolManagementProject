package se.shjava.shahrzad.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private int courseId;
    private static int courseIdCounter;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> listOfStudents;

    public Course(int courseId, String courseName, LocalDate startDate, int weekDuration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.listOfStudents=new ArrayList<>();
    }
    public Course(String courseName, LocalDate startDate, int weekDuration){
        this(++courseIdCounter, courseName,startDate,weekDuration);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

   public void registerStudents(Student student){
        if (!listOfStudents.contains(student)) {
            listOfStudents.add(student);
            System.out.println("Student added!" + student.getStudentName()+ " " + getCourseName());
        }
    }

   public void removeStudent(Student student){              //unregister
        listOfStudents.remove(student);
       System.out.println("Student is removed" + student.getStudentName());
   }
   public Student findStudentByEmail(String email){
        for(Student st: listOfStudents){
            if(st.getEmail()==email){}
            return st;
        }
        return null;
   }
   public Student findStudentById(int id){
        for(Student st: listOfStudents){
            if(st.getStudentId()==id){
                return st;
            }
        }
        return null;
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId &&
                Objects.equals(courseName, course.courseName) &&
                Objects.equals(startDate, course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, startDate);
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                '}';
    }
}