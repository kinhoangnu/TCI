package tddexplored;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book{

    private List<Chapter> sortedList;

    public Book(ArrayList<Chapter> sortedList) {
        this.sortedList = sortedList;
        Collections.sort(this.sortedList);
    }

    public List<Chapter> getSortedList() {
        return sortedList;
    }


}
