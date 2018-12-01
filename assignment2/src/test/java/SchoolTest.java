import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SchoolTest {

    School school;
    Course course;

    @Test (expected = NullPointerException.class)
    public void getNameCannotBeNull(){
        //arrange
        LocalDate openDate = LocalDate.of(1999,2, 2);

        //act
        school = new School(null,openDate);

    }

    @Test (expected = NullPointerException.class)
    public void getOpeningDateCannotBeNull(){
        //act
        school = new School("Fontys",null);
    }

    @Test
    public void addCourseMustAddCourseToCourseListOfSchool() throws CourseDateException, DuplicateCourseException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,1);
        course = new Course("math", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        //act
        school.addCourse(course);
        //assert
        assertTrue(school.getCourseList().contains(course));
        assertEquals(1, school.getCourseList().size());
    }

    @Test (expected = CourseDateException.class)
    public void addCourseMustThrowExceptionIfCourseStartDateIsBeforeSchoolOpenDate() throws CourseDateException, DuplicateCourseException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,4);
        course = new Course("math", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        //act
        school.addCourse(course);
    }

    @Test (expected = DuplicateCourseException.class)
    public void addCourseMustThrowExceptionIfNamesOfCoursesAreDuplicated() throws DuplicateCourseException, CourseDateException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,1);
        Course course1 = new Course("math", courseStartDate, courseEndDate);
        Course course2 = new Course("math", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        //act
        school.addCourse(course1);
        school.addCourse(course2);
    }

    @Test
    public void getCourseByNameMustReturnCourseWithGivenName() throws DuplicateCourseException, CourseDateException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,1);
        Course course = new Course("math", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        school.addCourse(course);
        //act
        Course courseToCompare = school.getCourseByName("math");
        //assert
        assertEquals(courseToCompare, course);
        assertTrue(course.getName() == courseToCompare.getName());
    }

    @Test (expected = NullPointerException.class)
    public void getCourseByNameMustReturnNullIfCourseNameDoesNotExist(){
        //assert
        assertNull(school.getCourseByName("nothing"));
    }

    @Test
    public void getCourseNameListMustReturnListWithAllCourseNames() throws DuplicateCourseException, CourseDateException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,1);
        Course course1 = new Course("math", courseStartDate, courseEndDate);
        Course course2 = new Course("literature", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        school.addCourse(course1);
        school.addCourse(course2);
        //act
        List<String> nameList = school.getCourseNameList();
        //assert
        assertEquals(2, nameList.size());
        assertTrue(nameList.contains("math"));
        assertTrue(nameList.contains("literature"));
    }

    @Test (expected = NullPointerException.class)
    public void getCourseNameListMustReturnNullIfThereIsNoCourse(){
        //assert
        assertNull(school.getCourseNameList());
    }

    @Test
    public void getCourseListShouldReturnListOfAllCourse() throws DuplicateCourseException, CourseDateException {
        //arrange
        LocalDate courseStartDate = LocalDate.of(2018,2,2);
        LocalDate courseEndDate = LocalDate.of(2018,2,3);
        LocalDate schoolOpenDate = LocalDate.of(2018,2,1);
        Course course1 = new Course("math", courseStartDate, courseEndDate);
        Course course2 = new Course("literature", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        school.addCourse(course1);
        school.addCourse(course2);
        //act
        List<Course> courseList = school.getCourseList();
        //assert
        assertEquals(2, courseList.size());
        assertTrue(courseList.contains(course1));
        assertTrue(courseList.contains(course2));
    }

    @Test (expected = NullPointerException.class)
    public void getCourseListMustReturnNullIfThereIsNoCourse(){
        //assert
        assertNull(school.getCourseList());
    }
}
