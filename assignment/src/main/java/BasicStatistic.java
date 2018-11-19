import java.util.*;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private List<Double> myList = new ArrayList<Double>();

    public List<Double> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Double> myList) {
        this.myList = myList;
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        myList.add(valueToAdd);
    }

    @Override
    public void clearData(){
        myList.clear();
    };

    @Override
    public int numberOfDataItems(){
        if (myList.isEmpty())
            return 0;
        else
            return myList.size();
    }

    @Override
    public Double sum(){
        Double result = 0d;
        for (Double data : myList){
            result += data;
        }
        return result;
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
