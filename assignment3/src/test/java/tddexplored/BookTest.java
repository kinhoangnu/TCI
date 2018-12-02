package tddexplored;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book myBook;
    ArrayList<Chapter> myChapterList = new ArrayList<Chapter>();
    Chapter chapter1 = new Chapter("HappyTree", "1");
    Chapter chapter2 = new Chapter("SAD", "2");
    Chapter chapter3 = new Chapter("HappyTree2", "1.1");
    Chapter chapter4 = new Chapter("HappyTree1", "1.2");
    Chapter chapter5 = new Chapter("Live", "3");

    @Test
    void testBookConstructor() {
        myChapterList.add(chapter1);
        myChapterList.add(chapter2);
        myChapterList.add(chapter3);
        myChapterList.add(chapter4);
        myChapterList.add(chapter5);

        myBook = new Book(myChapterList);
        assertEquals("1.2", myBook.getSortedList().get(2).getNumber());
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}")
    @CsvSource({
            ",Luther",
            "Lost in the wind,"
    })
    public void constructorTest(String a, String b) throws IllegalArgumentException{
        try{
            myBook = new Book(a,b);
        }catch (IllegalArgumentException e){}
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}")
    @CsvSource({
            ",2.1",
            "Found it!,"
    })
    public void testAddChapterToBook(String a, String b) throws NullPointerException{
        try{
            myBook.addChapterToBook(a,b);
        }catch (NullPointerException e){}
    }




}