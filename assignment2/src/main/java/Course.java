import sun.util.calendar.BaseCalendar;

import java.time.LocalDate;

public class Course {
    String name;
    LocalDate startDate;
    LocalDate endDate;

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() throws CourseDateException {
        if (endDate.compareTo(startDate) < 0) {
            throw new CourseDateException();
        }
        else
        return endDate;
    }

    public Course(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }


}
