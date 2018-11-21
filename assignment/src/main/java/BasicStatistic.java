import java.util.*;
import java.util.function.DoubleToIntFunction;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private List<Double> myList = new ArrayList<>();

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
    public Double getMean() {
        Double total = 0d;
        Collections.sort(myList);
        if (myList.isEmpty())
            throw new IndexOutOfBoundsException();
        else {
            for (int i = 0; i < myList.size(); i++) {
                total += myList.get(i);
            }
            return total / myList.size();
        }
    }

    @Override
    public double getMedian(){
        Double median;
        Collections.sort(myList);
        if (myList.isEmpty())
            throw new IndexOutOfBoundsException();
        else {
            if ((myList.size() % 2) == 0) {
                int firstMiddleIndex = myList.size() / 2;
                int secondMiddleIndex = firstMiddleIndex - 1;
                median = (myList.get(firstMiddleIndex) + myList.get(secondMiddleIndex)) / 2;
            } else {
                int index = ((myList.size() - 1) / 2);
                median = myList.get(index);
            }
            return median;
        }
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }
}
