package Question_1;

import java.util.Scanner;

public class StudentManagementApplication
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*************************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");

        String initialChoice = scanner.nextLine();
        
        if (!"1".equals(initialChoice))
        {
            System.out.println("Exiting the application. Goodbye!");
            System.exit(0);
        }

        while (true)
        {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice)
            {
                case "1":
                    captureStudent();
                    break;

                case "2":
                    searchStudent();
                    break;

                case "3":
                    deleteStudent();
                    break;

                case "4":
                    Student.StudentReport();
                    break;

                case "5":
                    Student.ExitStudentApplication();
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid menu option.");
            }
        }
    }

    private static void showMenu()
    {
        System.out.println("*************************************************");
        System.out.println("Please select one of the following menu items:");
        System.out.println("(1) Capture a new student.");
        System.out.println("(2) Search for a student.");
        System.out.println("(3) Delete a student.");
        System.out.println("(4) Print student report.");
        System.out.println("(5) Exit Application.");
        System.out.println("*************************************************");
    }

    private static void captureStudent()
    {
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*************************************************");

        System.out.print("Enter the student id: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();

        int age = captureStudentAge();

        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student student = new Student(studentId, name, age, email, course);
        Student.SaveStudent(student);
    }

    private static int captureStudentAge()
    {
        int age = 0;
        boolean validAge = false;

        while (!validAge)
        {
            System.out.print("Enter the student age: ");
            String ageInput = scanner.nextLine();

            try
            {
                age = Integer.parseInt(ageInput);

                if (age < 16)
                {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                }
                else
                {
                    validAge = true;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
            }
        }

        return age;
    }

    private static void searchStudent()
    {
        System.out.print("Enter the student id to search: ");
        String studentId = scanner.nextLine();

        Student student = Student.SearchStudent(studentId);

        if (student != null)
        {
            System.out.println("---------------------------------------------");
            System.out.println("STUDENT ID: " + student.getStudentId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
            System.out.println("---------------------------------------------");
        }
        else
        {
            System.out.println("---------------------------------------------");
            System.out.println("Student with Student Id: " + studentId + " was not found!");
            System.out.println("---------------------------------------------");
        }
    }

    private static void deleteStudent()
    {
        System.out.print("Enter the student id to delete: ");
        String studentId = scanner.nextLine();

        System.out.println("Are you sure you want to delete student " + studentId + " from the system? Yes (y) to delete.");
        String confirmation = scanner.nextLine();

        if ("y".equalsIgnoreCase(confirmation))
        {
            boolean success = Student.DeleteStudent(studentId);

            if (success)
            {
                System.out.println("---------------------------------------------");
                System.out.println("Student with Student Id: " + studentId + " WAS deleted!");
                System.out.println("---------------------------------------------");
            }
            else
            {
                System.out.println("---------------------------------------------");
                System.out.println("Student with Student Id: " + studentId + " was not found!");
                System.out.println("---------------------------------------------");
            }
        }
    }
}
