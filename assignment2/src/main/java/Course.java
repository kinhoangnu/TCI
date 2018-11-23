import java.time.LocalDate;

public class Course {

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate()  { return endDate; }

    public Course(String name, LocalDate startDate, LocalDate endDate) throws CourseDateException{
        this.name = name;
        this.startDate = startDate;
        if (endDate.compareTo(startDate) < 0) {
            throw new CourseDateException("the ending date is earlier than the starting date");
        }
        else {
            this.endDate = endDate;
        }
    }
}
