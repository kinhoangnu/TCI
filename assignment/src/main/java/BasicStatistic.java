import java.util.*;
import java.util.function.DoubleToIntFunction;

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
        Double mean = 0d;
        if(myList.isEmpty())
            throw new NoDataItemsException();
        else
        for (int i = 0; i< myList.size(); i++){
            mean += myList.get(i);
        }
        return mean/myList.size();
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        Double median = 0d;
        if(myList.isEmpty())
            throw new NoDataItemsException();
        else {
            if((myList.size() & 1) == 0){
                Double leftMiddle = myList.get((myList.size()/2)-1);
                Double rightMiddle = myList.get(myList.size()/2);
                median = (leftMiddle+rightMiddle)/2;
            }else{
                Double i = (myList.size()/2)+0.5;
                median = myList.get((int)Math.round(i)-1);
            }
        }
            return median;

    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }
}
