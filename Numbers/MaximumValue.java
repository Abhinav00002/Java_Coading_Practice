package Numbers;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaximumValue {
    // Maximum Value from Integer Array
    public static void main(String[] args) {
        int[] number={1,23,3,4,5,56,6,4,2,2,3,3,2,32,3,3,3,3,3,32,2};
        System.out.println(maxValue(number));
    }
    public static int maxValue(int[] arr){
        return Arrays.stream(arr).max().orElseThrow(NoSuchElementException :: new);
    }
}
