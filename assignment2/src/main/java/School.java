import java.time.LocalDate;
import java.util.*;

public class School {
    public String getName() throws CourseDateException{
        if(name == null)
            throw new CourseDateException();
        else
        return name;
    }

    public LocalDate getOpeningDate() throws CourseDateException{
        if(openingDate == null)
            throw new CourseDateException();
        else
        return openingDate;
    }

    String name;
    LocalDate openingDate;
    ArrayList<Course> courseList;
    ArrayList<String> courseNameList;

    public School(String name, LocalDate openingDate) {
        this.name = name;
        this.openingDate = openingDate;
        this.courseList = new ArrayList<Course>();
    }

    public void addCourse(Course course) throws CourseDateException, DuplicateCourseException{
        if(course.startDate.compareTo(openingDate) < 0){
            throw new CourseDateException();
        }
        for (Course c: courseList){
            if(c.name == course.name)
            throw new DuplicateCourseException();
        }
        courseList.add(course);
    }

    public Course getCourseByName(String name){
        for (Course c: courseList){
            if(c.name == name)
                return c;
        }
            return null;
    }

    public ArrayList<String> getCourseNameList(){
        courseNameList = new ArrayList<String>();
        for (Course c: courseList) {
            courseNameList.add(c.name);
        }
        return courseNameList;
    }

    public ArrayList<Course> getCourseList(){
        return courseList;
    }

}
