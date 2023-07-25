package gui_swing_events;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 
 */
public class Excel {
    private List<Double> values = new ArrayList<>();
    
    public Excel(ArrayList<Double> values) {
        this.values = values;
    }
    
    public Excel (String values) {
        // System.out.println("Given values as string: [" + values + "]");
        String [] splitStringValues = values.split("\\s+");
        List<String> listOfStringValues = Arrays.asList(splitStringValues);
        listOfStringValues.forEach(value -> this.values.add(Double.valueOf(value)));
    }
    
    public List<Double> getValues() {
        return this.values;
    }
    
    /**
     * This method sums up the values to provide total sum
     * @return the sum
     */
    public Double findTotal() {
        Double[] total = {0.0};
        this.values
                .stream()
                .forEach(value -> { 
                    total[0] += value;
                });
        return total[0];
    }
    
    /**
     * This method finds the average values of the provided numbers
     * @return average if there are values else 0.0
     */
    public Double findAverage() {
        
        int numberOfValues = this.values.size();
        Double sumOfValues = this.findTotal();
        
        if(numberOfValues == 0) {
            System.err.println("Error, cannot find average of 0 values. Add values to continue");
            return 0.0;
            //throw new IllegalArgumentException("Error, cannot find average of 0 values. Add values to continue");
        } else {
            Double average = sumOfValues/numberOfValues;
            return average;
        }
    }
    
    /**
     * This method finds a max value when provided with a list of values
     * @return max value
     */
    public Double findMax() {
        if (this.values.isEmpty())
            return null;
        else {
            Double firstValue = this.values.get(0);
            Double[] maxValue = {firstValue}; // used an array instead of a simple Double cause it is used in a lambda
            
            this.values.forEach(value -> {
            if (value > maxValue[0])
                maxValue[0] = value;
            });
            return maxValue[0];
        }
    }
    
    public Double findMin() {
        
        if (this.values.isEmpty())
            return null;
        else {
            Double firstValue = this.values.get(0);
            Double[] maxValue = {firstValue}; // used an array instead of a simple Double cause it is used in a lambda
            
            this.values.forEach(value -> {
            if (value < maxValue[0])
                maxValue[0] = value;
            });
            return maxValue[0];
        }
    }
}
