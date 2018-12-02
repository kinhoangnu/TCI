package tddexplored;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book{

    private List<Chapter> sortedList;
    private String name;
    private String author;
    private Chapter chapter;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author == null){
            throw new IllegalArgumentException();
        }
        this.author = author;
    }

    public Book(ArrayList<Chapter> sortedList) {
        this.sortedList = sortedList;
        Collections.sort(this.sortedList);
    }

    public List<Chapter> getSortedList() {
        return sortedList;
    }


    public void addChapterToBook(String name, String number){
        Chapter chapterToAdd = new Chapter(name,number);
        sortedList.add(chapterToAdd);
        Collections.sort(sortedList);
    }
}
