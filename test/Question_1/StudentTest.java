package Question_1;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest
{
    @Test
    public void TestSaveStudent()
    {
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@ymail.com", "disd");
        Student.SaveStudent(student);
        Student result = Student.SearchStudent("10111");
        assertNotNull(result);
        assertEquals("J.Bloggs", result.getName());
    }

    @Test
    public void TestSearchStudent()
    {
        Student student = new Student("10112", "J.Doe", 21, "jdoe@ymail.com", "disd");
        Student.SaveStudent(student);
        Student result = Student.SearchStudent("10112");
        assertNotNull(result);
        assertEquals("J.Doe", result.getName());
    }

    @Test
    public void TestSearchStudent_StudentNotFound()
    {
        Student result = Student.SearchStudent("99999");
        assertNull(result);
    }

    @Test
    public void TestDeleteStudent()
    {
        Student student = new Student("10113", "P.Parker", 20, "spidey@ymail.com", "disn");
        Student.SaveStudent(student);
        boolean deleted = Student.DeleteStudent("10113");
        assertTrue(deleted);
        assertNull(Student.SearchStudent("10113"));
    }

    @Test
    public void TestDeleteStudent_StudentNotFound()
    {
        boolean deleted = Student.DeleteStudent("55555");
        assertFalse(deleted);
    }

    @Test
    public void TestStudentAge_StudentAgeValid()
    {
        assertTrue(isValidAge("18"));
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid()
    {
        assertFalse(isValidAge("10"));
    }

    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter()
    {
        try
        {
            Integer.parseInt("c");
            fail("Expected NumberFormatException not thrown");
        }
        catch (NumberFormatException e)
        {
            // Expected exception
        }
    }

    private boolean isValidAge(String ageInput)
    {
        try
        {
            int age = Integer.parseInt(ageInput);
            return age >= 16;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
