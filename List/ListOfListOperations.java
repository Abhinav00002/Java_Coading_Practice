package List;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfListOperations {
    public static final List<List<String>> records = new ArrayList<>();
    static {
    // list = [Date, Salary, Name, Age, Designation]
    records.add(Arrays.asList("2025-08-01", "50000", "Alice", "30", "Developer"));
    records.add(Arrays.asList("2025-08-01", "50000", "alice", "30", "developer"));  // duplicate with case difference
    records.add(Arrays.asList("2025-08-02", "60000", "Bobadbabbaadddaoooad", "35", "Manager"));
    records.add(Arrays.asList("2025-08-03", "70000", "CHARLIE", "28", "Analyst"));
    records.add(Arrays.asList("2025-08-04", "80000", "D@vid", "40", "Sr. Developer")); // special character in name
    records.add(Arrays.asList("2025-08-04", "80000", "D@vid", "40", "Sr. Developer")); // exact duplicate
    records.add(Arrays.asList("2025-08-05", "55000", "Eve", "27", "Developer"));
    records.add(Arrays.asList("2025-08-05", "55000", "Eve", "27", "developer")); // case difference in designation
    records.add(Arrays.asList("2025-08-06", "60000", "Frank", "32", "QA Tester"));
    records.add(Arrays.asList("2025-08-06", "60000", "frank", "32", "QA Tester")); // case difference in name
    }

    public static void main(String[] args) {
//        records.forEach(s-> System.out.println(s));
        countTotalRecords(records);
        removeExactDuplicates(records);
        printAllName(records);
        filterByDesignation(records);
        caseInsensitiveDuplicateNameCheck(records);
        caseInsensitiveDuplicateDesignationCheck(records);
        caseInsensitiveUniqueDesignationCheck(records);
        findMaxAndMinSalary(records);
        groupEmployeeByAge(records);
        employeeByAgeAndPrintName(records);
        countSpecialCharactersInName(records);
        removeDuplicatesIgnoringCaseInNameAndDesignation(records);
        findLargestName(records);
        longestSubStringWithoutRepeatingCharacters(records);
    }

    private static void longestSubStringWithoutRepeatingCharacters(List<List<String>> records) {
        for (List<String> record : records) {
            if (record.size() > 2) {
                String target = record.get(2);
                int length = longestUniqueSubStrings(target);
                System.out.println("Longest unique substring length in: " + target + " = " + length);
            } else {
                System.out.println("Record does not have enough elements: " + record);
            }
        }

        String list = records.stream()
                .map(s -> s.get(2))
                .max(Comparator.comparingInt(s -> longestUniqueSubStrings(s))).orElse("");
        System.out.println(getLongestUniqueSubstring(list));

    }

//sliding window implementation
    private static Integer longestUniqueSubStrings(String record) {
        Set<Character> characters=new HashSet<>();
        int max=0,i=0,j=0;
        while (j<record.length())
        {
            if (!characters.contains(record.charAt(j))){
                characters.add(record.charAt(j));
                j++;
                max=Math.max(max, j-1);
            }else {
                characters.remove(record.charAt(i));
                i++;
            }
        }
        return max;
    }

    private static String getLongestUniqueSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int i = 0, j = 0, maxLen = 0, start = 0;

        while (j < s.length()) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j));
                if (j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
                j++;
            } else {
                seen.remove(s.charAt(i));
                i++;
            }
        }
        return s.substring(start, start + maxLen);
    }


    private static void findLargestName(List<List<String>> records) {
        String s = records.stream().map(record -> record.get(2))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Find Largest Name: "+ s);
    }

    private static void removeDuplicatesIgnoringCaseInNameAndDesignation(List<List<String>> records) {
        Set<String> seen= new HashSet<>();
        List<List<String>> lists = records.stream().filter(r -> seen.add((r.get(2) + " - " + r.get(4)).toLowerCase())).toList();
        System.out.println("Remove Duplicates Ignoring Case in Name and Designation: "+lists);
//        lists.forEach(strings -> strings.forEach(System.out::println));
    }

    private static void countSpecialCharactersInName(List<List<String>> records) {
        Long lists = records.stream().filter(strings -> !strings.get(2).matches("[a-zA-Z]")).count();
//                .toList();
        System.out.println("Count Special Characters In Name: "+lists);
    }

    private static void employeeByAgeAndPrintName(List<List<String>> records) {
        records.stream().
                collect(
                        Collectors.groupingBy(
                                record->record.get(3)//age
                                ,Collectors.mapping(
                                        rec-> rec.get(2),Collectors.toList())))
                .entrySet()
                .forEach(System.out::println);
    }

    private static void groupEmployeeByAge(List<List<String>> records) {
        records.stream()
                .map(record -> Integer.parseInt(record.get(3)))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().forEach(System.out::println);

    }

    private static void findMaxAndMinSalary(List<List<String>> records) {
        Integer max = records.stream().map(record -> Integer.parseInt(record.get(1))).max(Integer::compareTo).orElse(0);
        Integer min = records.stream().map(record -> Integer.parseInt(record.get(1))).min(Integer::compareTo).orElse(0);
        System.out.println("Max Salary: "+max+ "\nMin Salary: "+min);
    }

    private static void caseInsensitiveUniqueDesignationCheck(List<List<String>> records) {
        List<String> list = records.stream().map(record -> record.get(4).toLowerCase()).distinct().toList();
        System.out.println("Unique Designation(List): " +list);

        Set<String> collect = records.stream().map(record -> record.get(4).toLowerCase()).collect(Collectors.toSet());
        System.out.println("Unique Designation(SET): "+collect);

    }

    private static void caseInsensitiveDuplicateDesignationCheck(List<List<String>> records) {
        Map<String, Long> collect = records.stream().map(record -> record.get(4).toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().forEach(System.out::println);
    }

    private static void caseInsensitiveDuplicateNameCheck(List<List<String>> records) {
        Map<String, Long> collect = records.stream().map(record -> record.get(2).toLowerCase()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue()>1).forEach(System.out::println);
    }

    private static void filterByDesignation(List<List<String>> records) {
        List<List<String>> result=records.stream().filter(record -> record.contains("Manager")).toList();
        result.forEach(System.out::println);
    }

    private static void printAllName(List<List<String>> records) {
        List<String> result=records.stream().map(record -> record.get(2)).toList();
        System.out.println("Print All Name: "+ result);
    }

    private static void removeExactDuplicates(List<List<String>> records) {
        List<List<String>> list = records.stream().distinct().toList();
        list.forEach(System.out::println);
    }

    private static void countTotalRecords(List<List<String>> records) {
//        long count = records.stream().count();
        long count = records.size();
        System.out.println("Total Records: "+ count);
    }
}
