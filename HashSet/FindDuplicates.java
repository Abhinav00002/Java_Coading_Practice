package HashSet;

import java.util.HashSet;

public class FindDuplicates {
    // Question: Write a program to find duplicate elements in an array using HashSet.
  public static void main(String[] args) {
    int[] numbers={1,2,3,4,5,6,7,3,4};
    HashSet<Integer> set=new HashSet<>();
    HashSet<Integer> duplicates=new HashSet<>();
    for(int number:numbers){
        if(!set.add(number)){
            duplicates.add(number);
        }
    }
    System.out.println("Duplicates : "+duplicates);
  }
}
