package stats;

import java.util.List;

/**
 * Step 3 requirement: implement and use at least one generic method or generic class.
 * You may use this method or implement your own.
 */
public class StatsUtil {

    public static <T extends Number> double mean(List<T> values) {

        if (values.isEmpty()){
            throw new ArithmeticException("List is empty, cannot compute mean");
        }

        Double sum = 0.0;

        for (T value : values) {
            sum += value.doubleValue();
        }

        return sum / values.size();
    }

    public static <T extends Number> double min(List<T> values){
        if (values.isEmpty()){
            throw new ArithmeticException("List is empty, cannot compute min value");
        }

        Double min = values.get(0).doubleValue();
        
        for (int i = 1; i < values.size(); i++) {
            Double curVal = values.get(i).doubleValue();
            if (curVal < min) {
                min = curVal;
            } 
        }
        
        return min;
    }

    public static <T extends Number> double max(List<T> values){
        if (values.isEmpty()){
            throw new ArithmeticException("List is empty, cannot compute min value");
        }

        Double max = values.get(0).doubleValue();
        
        for (int i = 1; i < values.size(); i++) {
            Double curVal = values.get(i).doubleValue();
            if (curVal > max) {
                max = curVal;
            } 
        }

        return max;
    }

    private StatsUtil() {}
}
