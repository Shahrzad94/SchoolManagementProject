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
                    "4. Edit students and courses" + " " +
                    "5. Exit "  );
            String getInput = scanner.nextLine();
            if(getInput.equalsIgnoreCase("5")){
                break;
            }
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
                        System.out.println("Course is created!" + newCourse.toString());

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
                        System.out.println("You have entered the requested email " );
                        System.out.println("Student is registered!" + studentMail);
                        System.out.println("*****************************************************************************************************************************************");

                   } else if (choice.equalsIgnoreCase("D")) {                                //deleting student is left
                        System.out.println("Here you can delete a student from a course");
                        for(Course course: courseList.findAll()){
                            System.out.println(course.getCourseName());}
                        System.out.println("to delete a student enter a valid mail");
                        Student email = studentList.findByEmail(scanner.nextLine());
                      try{
                          courseList.findById(scanner.nextInt()).removeStudent(email);}
                      catch ( InputMismatchException ex){
                          System.out.println("Enter a valid input");
                      }
                        System.out.println("Selected student is removed now ...");

                    }

                    break;
                }
                case "3": {
                    System.out.println("Here you can find a student or your course");
                    System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("to find a student press (S) and to find a course press (C)");
                    String choice3 = scanner.nextLine();

                    if (choice3.equalsIgnoreCase("S")) {
                        System.out.println("You can find students by : 1. name" +
                                " 2. id" +
                                " 3. email" );
                        String choice3FindingStudents= scanner.nextLine();
                        if (choice3FindingStudents.equalsIgnoreCase("1")){
                            System.out.println("Finding student by name: ");
                            String stName = scanner.nextLine();
                            System.out.println(studentList.findByName(stName) + stName);
                        } else if (choice3FindingStudents.equalsIgnoreCase("2")){
                            System.out.println("Finding student by Id");
                            int stId= scanner.nextInt();
                            System.out.println(studentList.findById(stId));
                        } else if (choice3FindingStudents.equalsIgnoreCase("3")){
                            System.out.println("Finding student by email");
                            String stEmail= scanner.nextLine();
                            System.out.println(studentList.findByEmail(stEmail));

                        }  }
                    else if (choice3.equalsIgnoreCase("C")) {
                        System.out.println("Finding a course ......");
                        System.out.println("You can find your course by : " +
                                "1. Course Name" +
                                 "2. Course id" +
                                  "3. Course date");
                        String choice3FindingCourse= scanner.nextLine();
                        if(choice3FindingCourse.equalsIgnoreCase("1")){
                            System.out.println("Finding course by name: pls write the course name");
                            String CourseName= scanner.nextLine();
                            System.out.println(courseList.findByName(CourseName));
                        } else if (choice3FindingCourse.equalsIgnoreCase("2")){
                            System.out.println("Finding a course by id");
                            int courseId= scanner.nextInt();
                            System.out.println(courseList.findById(courseId));

                        } else if (choice3FindingCourse.equalsIgnoreCase("3")){
                            System.out.println("Enter a valid date to find the course ");
                            LocalDate courseDate= LocalDate.parse(scanner.nextLine());
                            System.out.println(courseList.findByDate(courseDate));
                        }
                    }
                }
                break;

                case "4": {
                    System.out.println("Here you can edit any students or any course");
                    System.out.println("to edit a student press S and to edit a course press C");
                    String choice4 = scanner.nextLine();
                    if (choice4.equalsIgnoreCase("S")) {
                        System.out.println("You can enter the student email to edit the student!");
                        System.out.println("******* Enter updated information ********");
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
                        System.out.println("Here you can enter wished course id to edit the chosen course");
                        System.out.println("****** Enter new information ******");
                        System.out.println("Enter a new Course name: ");
                        String cName= scanner.nextLine();
                        System.out.println("Enter a valid issue date: ");
                        LocalDate cDate= LocalDate.parse(scanner.nextLine());
                        System.out.println("Enter a new duration of the course: ");
                        int courseDuration= Integer.parseInt(scanner.next());

                        System.out.println("Your course is edited :)  ");
                        Course editedCourse= new Course(cName,cDate,courseDuration);
                        courseList.saveCourse(editedCourse);

                    }
                    break;

                  }
                }

            }
        }
    }
