package se.shjava.shahrzad;
import se.shjava.shahrzad.data.CourseDaoList;
import se.shjava.shahrzad.data.StudentDaoList;
import se.shjava.shahrzad.model.Course;
import se.shjava.shahrzad.model.Student;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowProgram {

    private Course course1 = new Course(88, "Java", LocalDate.parse("2019-09-30"), 6);
    private Course course2 = new Course(99, "HTML", LocalDate.parse("2019-09-30"), 5);
    private Course course3 = new Course(100, "English", LocalDate.parse("2019-10-10"), 8);
    private Course course4 = new Course(120, "Svenska som Andra Språk", LocalDate.parse("2020-01-01"), 10);
    private Student student1 = new Student(1, "Shahrzad", "sh@gmail.com", "PG Väg");
    private Student student2 = new Student(2, "Olle", "olle@gmail.com", "ICA street");
    private Student student3 = new Student(3, "Bobby", "bob@gmail.com", "Storgatan");

    private CourseDaoList courseList = new CourseDaoList();
    private StudentDaoList studentList = new StudentDaoList();

    public void showProgram() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your school");
        System.out.println("Here is a short information about how the program works");
        System.out.println(" ***************************************************************************************** ");

        boolean keepAlive = true;
        while (keepAlive) {
            System.out.println("Enter a number between 1 to 4 in order to  : " + " " +
                    "1.Create new Courses and Students" + " " +
                    "2. Register and remove students to/from courses" + " " +
                    "3. Finding students and courses " + " " +
                    "4. Edit students and courses");
            String getInput = scanner.nextLine();
            switch (getInput) {
                case "1":
                    System.out.println(" To create a course click C and to create a student click S");
                    String getNumber = scanner.nextLine();
                    if (getNumber.equalsIgnoreCase("C")) {
                        System.out.println("Creating courses in process.... ");
                        System.out.println("Please write a name : ");
                        String courseName = scanner.nextLine();
                        System.out.println("Enter the course id : ");
                        String id = scanner.nextLine();
                        int courseId = Integer.parseInt(id);
                        System.out.println("Please write the date of issue : ");
                        String date = scanner.nextLine();
                        LocalDate dateOfIssue = LocalDate.parse(date);
                        System.out.println("Please write the duration of requested course based on weeks: ");
                        String courseDuration = scanner.nextLine();
                        int duration = Integer.parseInt(courseDuration);
                        Course newCourse = new Course(courseId, courseName, dateOfIssue, duration);
                        System.out.println("Course is created!");

                    } else if (getNumber.equalsIgnoreCase("S")) {
                        System.out.println("Enter the student id");
                        String studentId = scanner.nextLine();
                        int stId = Integer.parseInt(studentId);

                        System.out.println("Write the name of student: ");
                        String stName = scanner.nextLine();
                        System.out.println("Enter the studentEmail: ");
                        String stEmail = scanner.nextLine();
                        System.out.println("Enter the valid address: ");
                        String studentAddress = scanner.nextLine();
                        Student newStudent = new Student(stId, stName, stEmail, studentAddress);
                        System.out.println("new Student is made!" + newStudent);
                    }
                    break;


                case "2": {
                    System.out.println(" Register or Remove a student : to register a student enter R and to remove a student enter D ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("R")) {
                        System.out.println(" Register a student: Here you need to enter a valid email to register the student by mail :  ");
                        System.out.println(" ");
                        Scanner choice2 = new Scanner(System.in);
                        Student studentMail = studentList.findByEmail(choice2.nextLine());
                        System.out.println("You have entered the requested email ");
                        System.out.println("Student is registered!");
                        courseList.findById(scanner.nextInt()).registerStudents(studentMail);
                        System.out.println("*****************************************************************************************************************************************");

                   } else if (choice.equalsIgnoreCase("D")) {
                        System.out.println("Here you can delete a student from a course");
                        System.out.println("to delete a student enter a valid mail");


                    } break;
                }
                case "3": {
                    System.out.println("Here you can find a student or your course");
                    System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("to find a student press (S) and to find a course press (C)");
                    String choice3 = scanner.nextLine();

                    if (choice3.equalsIgnoreCase("S")) {
                        System.out.println("You can find students by : 1. name" +
                                " 2. id" +
                                " 3. email" +
                                " 4. list of all students");
                        System.out.println("Finding student by name: ");
                        String stName = scanner.nextLine();
                        System.out.println(studentList.findByName(stName));
                    } else if (choice3.equalsIgnoreCase("C")) {
                        System.out.println("Finding a course ......");
                        String courseName = scanner.nextLine();
                        System.out.println(courseList.findByName(courseName));
                    }
                }
                break;
                case "4": {
                    System.out.println("Here you can edit any students or any course");
                    System.out.println("to edit a student press S and to edit a course press C");
                    String choice4 = scanner.nextLine();
                    if (choice4.equalsIgnoreCase("S")) {
                        System.out.println("You can enter the student email to edit the student!");

                        Student stByEmail = studentList.findByEmail(scanner.nextLine());
                        System.out.println("Enter updated information");
                        System.out.println("Edited Name : ");
                        String newName = scanner.nextLine();
                        System.out.println(" Edited Email : ");
                        String newEmail = scanner.nextLine();
                        System.out.println("Edited address : ");
                        String newAddress = scanner.nextLine();

                        Student editStudent = new Student(newName, newEmail, newAddress);
                        studentList.saveStudent(editStudent);
                        System.out.println("Student is updated: "+ editStudent.toString());


                    } else if(choice4.equalsIgnoreCase("C")){
                        System.out.println("Here you can enter wished course id to edit");

                       Course listOfCourses= courseList.findById(scanner.nextInt());
                        System.out.println("Write a new name: ");

                   try {
                       scanner.nextLine();
                       listOfCourses.setCourseName(scanner.nextLine());            //doesnt go through this line! NullPointerException
                       System.out.println("Course name is updated !! ");

                       System.out.println(" Update the date of issue of the course: enter the date of issue");
                       listOfCourses.setStartDate(LocalDate.parse(scanner.nextLine()));
                       System.out.println("The date of course is now updated!");

                       System.out.println("Enter new duration of course");
                       scanner.nextLine();
                       listOfCourses.setWeekDuration(Integer.parseInt(scanner.next()));
                       System.out.println(" Duration is updated ...");
                       System.out.println(" Your new course is now made : " + listOfCourses.toString());
                   } catch (NullPointerException ex){

                       System.out.println("Enter valid information");
                   }
                    }
                    break;
                }

            }
        }
    }
}