package se.shjava.shahrzad;
import se.shjava.shahrzad.data.CourseDaoList;
import se.shjava.shahrzad.data.StudentDaoList;
import se.shjava.shahrzad.model.Course;
import se.shjava.shahrzad.model.Student;
import java.time.LocalDate;
import java.util.Scanner;

public class ShowProgram {

    private Course course1= new Course(88, "Java", LocalDate.parse("2019-09-30"), 6);
    private Course course2= new Course(99,"HTML", LocalDate.parse("2019-09-30"), 5);
    private Course course3= new Course(100, "English", LocalDate.parse("2019-10-10"), 8);
    private Course course4= new Course(120, "Svenska som Andra Språk", LocalDate.parse("2020-01-01"), 10);
    private Student student1= new Student(1, "Shahrzad", "sh@gmail.com", "PG Väg");
    private Student student2= new Student(2,"Olle", "olle@gmail.com", "ICA street");
    private Student student3= new Student(3, "Bobby", "bob@gmail.com", "Storgatan");

    private CourseDaoList courseList = new CourseDaoList();
    private StudentDaoList studentList = new StudentDaoList();
    public void showProgram() {


        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to your school");
        System.out.println("Here is a short information about how the program works");
        System.out.println(" ***************************************************************************************** ");

        boolean keepAlive= true;
        while (keepAlive){
            System.out.println( "Enter a number between 1 to 4 in order to  : " + " " +
                                "1.Create new Courses and Students" + " " +
                                "2. Register and remove students to/from courses" + " " +
                                "3. Finding students and courses in various ways" + " " +
                                "4. Edit students and courses");
            String getInput= scanner.nextLine();
            switch (getInput){
                case "1":
                    System.out.println(" To create a course click C and to create a student click S");
                    String getNumber= scanner.nextLine();
                    if(getNumber.equalsIgnoreCase("C")){
                        System.out.println("Creating courses in process.... ");
                        System.out.println("Please write a name : ");
                       String courseName= scanner.nextLine();
                        System.out.println("Enter the course id : ");
                        String id= scanner.nextLine();
                        int courseId= Integer.parseInt(id);
                        System.out.println("Please write the date of issue : ");
                        String date = scanner.nextLine();
                        LocalDate dateOfIssue= LocalDate.parse(date);
                        System.out.println("Please write the duration of requested course based on weeks: ");
                        String courseDuration = scanner.nextLine();
                        int duration= Integer.parseInt(courseDuration);
                        Course newCourse= new Course(courseId,courseName,dateOfIssue,duration);
                        System.out.println("Course is created!" );

                    }
                    else if (getNumber.equalsIgnoreCase("S")){
                    System.out.println("Enter the student id");
                    String studentId= scanner.nextLine();
                    int stId= Integer.parseInt(studentId);

                    System.out.println("Write the name of student: ");
                    String stName= scanner.nextLine();
                    System.out.println("Enter the studentEmail: ");
                    String stEmail= scanner.nextLine();
                    System.out.println("Enter the valid address: ");
                    String studentAddress= scanner.nextLine();
                    Student newStudent= new Student(stId, stName,stEmail,studentAddress);
                    System.out.println("new Student is made!" + newStudent);
                    }
                    break;

                case "2":
                {
                    System.out.println(" Register or Remove a student : to register a student enter R and to remove a student enter D ");
                    String choice= scanner.nextLine();
                    if(choice.equalsIgnoreCase("R")){
                        System.out.println(" Register a student : you need to select a student from the list : ");
                        System.out.println("Select a student by email or id");
                    /// register/remove student
                    }

                }
            }
        }

            }}