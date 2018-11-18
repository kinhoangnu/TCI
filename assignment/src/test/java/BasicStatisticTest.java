import org.junit.Test;
import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test
    public void addDoubleToData(){
        //Arrange
        BasicStatistic bs = new BasicStatistic();

        //Act
        bs.addDoubleToData(1d);

        //Assert
        assertEquals(1, bs.numberOfDataItems());
    }
}
