package se.shjava.shahrzad.model;

import java.util.Objects;

public class Student {
    private  int studentId;
    private static int StudentIdCounter;
    private String studentName;
    private String email;
    private String address;

    public Student(int studentId, String studentName, String email, String address) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.address = address;
    }

    public Student(String studentName, String email, String address){
        this(++StudentIdCounter, studentName, email, address);
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId &&
                Objects.equals(studentName, student.studentName) &&
                Objects.equals(email, student.email) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, email, address);
    }
}
