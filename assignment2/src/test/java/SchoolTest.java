import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SchoolTest {

    School school;
    Course course;

    @Test (expected = CourseDateException.class)
    public void getNameCannotBeNull() throws CourseDateException {
        //arrange
        LocalDate openDate = LocalDate.of(1999,2, 2);
        school = new School(null,openDate);
        //act
        String name = school.getName();
    }

    @Test (expected = CourseDateException.class)
    public void getOpeningDateCannotBeNull() throws CourseDateException {
        //arrange
        school = new School("Fontys",null);
        //act
        LocalDate openDate = school.getOpeningDate();
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
        school.courseList.contains(course);
    }

    @Test (expected = CourseDateException.class)
    public void addCourseMustThrowExceptionIfCourseEndDateIsBeforeCourseStartDate() throws CourseDateException, DuplicateCourseException {
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
        Course course1 = new Course("math", courseStartDate, courseEndDate);
        Course course2 = new Course("literature", courseStartDate, courseEndDate);
        school = new School("Fontys", schoolOpenDate);
        school.addCourse(course1);
        school.addCourse(course2);
        //act
        Course courseToCompare = school.getCourseByName("math");
        //assert
        assertEquals(courseToCompare,course1);
    }

    @Test (expected = NullPointerException.class)
    public void getCourseByNameMustReturnNullIfCourseNameDoesNotExist(){
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
        ArrayList<String> nameList = school.getCourseNameList();
        //assert
        assertTrue(nameList.contains("math"));
        assertTrue(nameList.contains("literature"));
    }

    @Test (expected = NullPointerException.class)
    public void getCourseNameListMustReturnNullIfThereIsNoCourse(){
        ArrayList<String> nameList = school.getCourseNameList();
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
        ArrayList<Course> courseList = school.getCourseList();
        //assert
        assertTrue(courseList.contains(course1));
        assertTrue(courseList.contains(course2));
    }

    @Test (expected = NullPointerException.class)
    public void getCourseListMustReturnNullIfThereIsNoCourse(){
        ArrayList<Course> courseList = school.getCourseList();
    }

}
