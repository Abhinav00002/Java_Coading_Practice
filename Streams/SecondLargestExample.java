package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
public class SecondLargestExample {
    public static void main(String[] args) {
        List<Integer> number=Arrays.asList(1,2,3,34,4,44,5,5,5,6,55,4);
        Optional<Integer> SecondLargestExample= number.stream()
        .distinct()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst();

        SecondLargestExample.ifPresent(s1->System.out.println("Second Largest: "+ s1));
    }
}
