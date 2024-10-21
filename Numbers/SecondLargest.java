package Numbers;

import java.util.Arrays; 

public class SecondLargest {
    public static void main(String[] args) {
        int[] number={1,2,3,4,45,565,6,56,5};
         int num=  Arrays.stream(number).distinct().sorted().toArray()[number.length - 2];
         System.out.println(num);
    }
}
