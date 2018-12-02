package tddexplored;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.rules.ExpectedException;


class ChapterTest {

    Chapter myChapter;

    @ParameterizedTest(name = "{index} => a={0}, b={1}")
    @CsvSource({
            ",2.1",
            "Happy tree, 2.3.3"
    })
    public void constructorTest(String a, String b) throws IllegalArgumentException{
        try{
            myChapter = new Chapter(a,b);
        }catch (IllegalArgumentException e){}
    }


}