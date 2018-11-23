import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CourseTest {

    Course course;
    LocalDate startDate;
    LocalDate endDate;

    @Test(expected = CourseDateException.class)
    public void getEndDate() throws CourseDateException {
        //arrange
        startDate = LocalDate.of(1999,1,1);
        endDate = LocalDate.of(1998,1,1);

        //act
        course = new Course("English", startDate, endDate);
    }
}