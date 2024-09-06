package Question_1;

import java.util.ArrayList;

public class Student
{
    private String studentId;
    private String name;
    private int age;
    private String email;
    private String course;

    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String studentId, String name, int age, String email, String course)
    {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    public static void SaveStudent(Student student)
    {
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    public static Student SearchStudent(String studentId)
    {
        for (Student student : students)
        {
            if (student.getStudentId().equals(studentId))
            {
                return student;
            }
        }
        return null;
    }

    public static boolean DeleteStudent(String studentId)
    {
        Student student = SearchStudent(studentId);
        
        if (student != null)
        {
            students.remove(student);
            return true;
        }
        
        return false;
    }

    public static void StudentReport()
    {
        int count = 1;
        
        for (Student student : students)
        {
            System.out.println("STUDENT " + count);
            System.out.println("------------------------------");
            System.out.println("STUDENT ID: " + student.getStudentId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
            System.out.println("------------------------------");
            count++;
        }
    }

    public static void ExitStudentApplication()
    {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getEmail()
    {
        return email;
    }

    public String getCourse()
    {
        return course;
    }
}
