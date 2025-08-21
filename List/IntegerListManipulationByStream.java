package List;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerListManipulationByStream {
    public static final List<Integer> list = new ArrayList<>(Arrays.asList(1,2,1,23,2,3,4,5,4,5,3,21,45,43,1,4,5,3,5,6,3,5,4,54,4,5,45,45,45,5,45,5, 2, 3, 4, 5));
    public static void main(String[] args){
        printOddAndEven(list);
        sortAList(list);
        removeDuplicates(list);
        totalCount(list);
        countOccurrenceOfEachNumber(list);
        duplicatesOnly(list);
        findMaxAndMin(list);
        sumOfAllNumber(list);
        averageValue(list);
        partitionByEvenAndOdd(list);
        groupByValueLikeHistogram(list);
        squareEachNumber(list);
        findFirstElementMatchingCondition(list);
        checkAllPositiveElement(list);
        checkIfAnyElementDevidedBy7(list);
        secondHighestNumberInList(list);

    }

    private static void secondHighestNumberInList(List<Integer> list) {
        Integer ored = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Second Highest Number in List: "+ored);

    }

    private static void checkIfAnyElementDevidedBy7(List<Integer> list) {
        String collected = list.stream()
                .filter(n -> n % 7 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Divided By 7: " +collected);
        boolean anyMatch = list.stream().anyMatch(n -> n % 7 == 0);
        System.out.println("Any Match Divided by 7: "+anyMatch);

    }

    private static void checkAllPositiveElement(List<Integer> list) {
        boolean allMatch = list.stream().allMatch(n -> n > 0);
        System.out.println("Check All Positive Element: "+allMatch);
    }

    private static void findFirstElementMatchingCondition(List<Integer> list) {
        Optional<Integer> first = list.stream().filter(n -> n % 2 == 0).findFirst();
        System.out.println("Find First Element Matching Condition: "+first);
    }

    private static void squareEachNumber(List<Integer> list) {
        String collected = list.stream()
                .map(n -> n * n)
//                .distinct()
//                .sorted()
                .map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Square Of Each Number: "+collected);
    }

    public static void printOddAndEven(List<Integer> list){

        String collected = list.stream()
                .filter(n -> n % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
//                .collect(Collectors.toList());
//                .forEach(System.out::print);
        System.out.println("Odd numbers: "+ collected);

        String collect = list.stream()
                .filter(n -> n % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Even numbers: "+ collect);
//                .forEach(System.out::print);
    }

    public static void sortAList(List<Integer> list){

        String sortedList = list.stream()
                .sorted() //By Default Ascending
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
//                .collect(Collectors.toList());
//                .forEach(System.out::print);

        System.out.println("Sorted(Ascending) List: "+sortedList);
        String descList = list.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
//                .forEach(System.out::print);
        System.out.println("Sorted(Descending) List: "+ descList);
    }

    public static void removeDuplicates(List<Integer> list){

        String removeduplicates = list.stream()
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
//                .forEach(System.out::print);
        System.out.println("Remove Duplicates(Unique): "+removeduplicates);
    }
    public static void totalCount(List<Integer> list){
        long count = list.stream().count();
        System.out.println("Count numbers: "+count);
    }
    public static void countOccurrenceOfEachNumber(List<Integer> list){
        System.out.println("Count occurrence of each numbers(Frequencies): ");
        Map<Integer, Long> longMap = list.stream()
                .collect(Collectors.groupingBy(
                        n -> n, Collectors.counting()
                ));
        System.out.println(longMap);
    }

    public static void duplicatesOnly(List<Integer> list){
        Set<Integer> dup= new HashSet<>();
        Set<Integer> collected = list.stream()
                .filter(n -> !dup.add(n))
                .collect(Collectors.toSet());
        System.out.println("Duplicates numbers only: "+collected);
    }

    private static void groupByValueLikeHistogram(List<Integer> list) {
        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(n -> n));
        System.out.println("Group By Value(Like Histogram): "+collect);
    }

    private static void partitionByEvenAndOdd(List<Integer> list) {
        Map<Boolean, List<Integer>> collectEvenOrOdd = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        collectEvenOrOdd.entrySet().stream().forEach(booleanListEntry -> {
            String key= booleanListEntry.getKey()?"Even":"Odd";
            System.out.println(key +" : "+booleanListEntry.getValue());
        });
        System.out.println("Partition By Even And Odd: ");
        System.out.println("Even: "+collectEvenOrOdd.get(true));
        System.out.println("odd: "+collectEvenOrOdd.get(false));
    }

    private static void averageValue(List<Integer> list) {
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average Value: "+average);
    }

    private static void sumOfAllNumber(List<Integer> list) {
        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum Of All Number In List: "+sum);
    }

    private static void findMaxAndMin(List<Integer> list) {
        Integer max = list.stream().max(Integer::compare).orElseThrow();
        System.out.println("Max in List: "+max);
        Integer min = list.stream().min(Integer::compare).orElseThrow();
        System.out.println("Min in List: "+min);
    }
}
