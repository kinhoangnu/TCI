import java.util.*;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private ArrayList myList = new ArrayList<Double>();

    public List<Double> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Double> myList) {
        this.myList = myList;
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        getMyList().add(valueToAdd);
    }

    @Override
    public void clearData(){
        getMyList().clear();
    };

    @Override
    public int numberOfDataItems(){
        if (getMyList().isEmpty())
            return 0;
        else
            return getMyList().size();
    }

    @Override
    public Double sum(){
        double rv = 0.0;
        return rv;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }
}
