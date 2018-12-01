import java.time.LocalDate;
import java.util.*;

public class School {

    private String name;
    private LocalDate openingDate;
    private List<Course> courseList;
    private List<String> courseNameList;

    public String getName(){
        return name;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }


    public List<Course> getCourseList(){
        return courseList;
    }

    public List<String> getCourseNameList(){
        return courseNameList;
    }

    public School(String name, LocalDate openingDate) {
        if (name == null){
            throw new NullPointerException("The name of the school cannot be null");
        }
        else {
            this.name = name;
        }
        if (openingDate == null){
            throw new NullPointerException("The opening date of the school cannot be null");
        }
        else {
            this.openingDate = openingDate;
        }
        this.courseList = new ArrayList<>();
        this.courseNameList = new ArrayList<>();
    }

    public void addCourse(Course course) throws CourseDateException, DuplicateCourseException{
        if(course.getStartDate().compareTo(openingDate) < 0){
            throw new CourseDateException("The starting date of a course cannot be earlier than that of a school");
        }
        if (!courseList.isEmpty()){
            for (Course c: courseList){
                if(c.getName() == course.getName())
                    throw new DuplicateCourseException("Course name is duplicated");
            }
        }
        courseList.add(course);
        courseNameList.add(course.getName());
    }

    public Course getCourseByName(String name){
        for (Course c: courseList){
            if(c.getName() == name)
                return c;
        }
        return null;
    }
}
