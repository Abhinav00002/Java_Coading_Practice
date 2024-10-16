package ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SecondLargest {
    // Question: Write a program to find the second largest element in an ArrayList.
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2 ,34,4,5,6);
        Collections.sort(list);
        System.out.println("Secnd Largest Elements: "+ list.get(list.size() - 2));
    }
}
