import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMeanMustThrowExceptionIfListIsEmpty(){
        //act
        basicStatistic.getMean();
    }

    @Test
    public void getMeanMustReturnTheMeanOfAllProducts(){
        //arrange
        Double result;
        basicStatistic.addDoubleToData(1d);
        basicStatistic.addDoubleToData(2d);
        basicStatistic.addDoubleToData(3d);
        //act
        result = basicStatistic.getMean();
        //assert
        assertEquals((Double)2d,result);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMedianMustThrowExceptionIfListIsEmpty(){
        //act
        basicStatistic.getMedian();
    }

    @Test
    public void getMedianMustReturnTheMiddleNumberIfNumberOfItemIsOdd(){
        //arrange
        Double result;
        basicStatistic.addDoubleToData(1d);
        basicStatistic.addDoubleToData(2d);
        basicStatistic.addDoubleToData(3d);
        basicStatistic.addDoubleToData(5d);
        basicStatistic.addDoubleToData(8d);
        //act
        result = basicStatistic.getMedian();
        //assert
        assertEquals((Double)3d,result);
    }

    @Test
    public void getMedianMustReturnTheMeanOfTwoMiddleNumbersIfNumberOfItemIsEven(){
        //arrange
        Double result;
        basicStatistic.addDoubleToData(1d);
        basicStatistic.addDoubleToData(2d);
        basicStatistic.addDoubleToData(3d);
        basicStatistic.addDoubleToData(4d);
        //act
        result = basicStatistic.getMedian();
        //assert
        assertEquals((Double)2.5,result);
    }

    @Test
    public void getStandardDeviation() {
        //arrange

        //act

        //assert
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void highestValue() {
        //arrange
        //act
        basicStatistic.highestValue();
    }

    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, c={2}, highest={3}")
    @CsvSource({
            "1d, 1d, 2d, 2d",
            "2d, 3d, 5d, 5d",
            "1000d, 3213d, 23d, 3213d"
    })
    public void highestValueMustReturnHighestValue(double a, double b,double c, double highest) {
        //arrange
        Double result;
        basicStatistic.addDoubleToData(a);
        basicStatistic.addDoubleToData(b);
        basicStatistic.addDoubleToData(c);
        //act
        //assert
        assertEquals((Double)highest,basicStatistic.highestValue());
    }
}