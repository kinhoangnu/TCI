import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BasicStatisticTest {

    private BasicStatistic basicStatistic = new BasicStatistic();

    @Test
    public void addDoubleToDataShouldReturnIncrementedValue() {
        //arrange
        Double value1 = 1d, value2 = 2d;
        boolean isEmpty;
        int size;

        //act
        basicStatistic.addDoubleToData(value1);
        basicStatistic.addDoubleToData(value2);
        isEmpty = basicStatistic.getMyList().isEmpty();
        size = basicStatistic.getMyList().size();

        //assert
        assertEquals(2, size);
        assertFalse(isEmpty);
    }

    @Test
    public void clearDataShouldReturnEmptyList() {
        //arrange
        basicStatistic.addDoubleToData(1d);
        boolean isEmpty;

        //act
        basicStatistic.getMyList().clear();
        isEmpty = basicStatistic.getMyList().isEmpty();

        //assert
        assertTrue(isEmpty);
    }

    @Test
    public void numberOfDataItemsMustReturnZero() {
        //arrange
        basicStatistic.getMyList().clear();

        //act
        int result = basicStatistic.numberOfDataItems();

        //assert
        assertEquals(0, result);
    }

    @Test
    public void sumMustReturnExactValue() {
        //arrange
        Double result;
        basicStatistic.addDoubleToData(1d);
        basicStatistic.addDoubleToData(2d);
        basicStatistic.addDoubleToData(3d);

        //act
        result = basicStatistic.sum();

        //assert
        assertEquals((Double)6d, result);
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