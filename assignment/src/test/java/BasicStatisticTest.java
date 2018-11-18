import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BasicStatisticTest {
    private BasicStatistic basicStatistic = new BasicStatistic();
    @Test
    public void addDoubleToData() {
        //arrange
        Double number;
        //act
        basicStatistic.addDoubleToData(1.1);
        number = basicStatistic.getMyList().get(0);
        //assert
        assertEquals((Double)1.1,number);
        assertFalse(basicStatistic.getMyList().isEmpty());
    }

    @Test
    public void clearData() {
        //arrange

        //act
        basicStatistic.getMyList().clear();
        //assert
        assertTrue(basicStatistic.getMyList().isEmpty());
    }

    @Test
    public void numberOfDataItems() {
        //arrange

        //act

        //assert
        assertEquals(0,basicStatistic.numberOfDataItems());
    }

    @Test
    public void sum() {
        //arrange

        //act

        //assert
    }

    @Test
    public void highestValue() {
        //arrange

        //act

        //assert
    }

    @Test
    public void getMean() {
        //arrange

        //act

        //assert
    }

    @Test
    public void getMedian() {
        //arrange

        //act

        //assert
    }

    @Test
    public void getStandardDeviation() {
        //arrange

        //act

        //assert
    }
}