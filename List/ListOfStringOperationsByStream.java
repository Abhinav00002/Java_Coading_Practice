package List;

import javax.xml.stream.events.Characters;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfStringOperationsByStream {
    private static final List<String> words = Arrays.asList(
            "apple",         // lowercase
            "banana",        // lowercase
            "Apple",         // duplicate, different case
            "BANANA",        // duplicate, uppercase
            "avocado",       // lowercase
            "blueberry",     // lowercase
            "Cherry",        // mixed-case
            "cherry",        // duplicate, lowercase
            "cHeRrY",        // duplicate, mixed-case
            "grape-fruit",   // special character '-'
            "mango123",      // numbers in string
            "kiwi!",         // special character '!'
            "@melon",        // special character '@'
            "  orange  ",    // leading/trailing spaces
            "",              // empty string
            " ",             // single whitespace
            "PineApple",     // mixed-case
            "dragonfruit",   // long word
            "fig",           // short word
            "APPLE",          // duplicate, uppercase
            "APPLE",          // duplicate
            "banana"          // duplicate
    );

    public static void main(String[] args) {
        filterByLength(words);
        convertAllToUpperAndLowerCases(words);
        removeEmptyOrBlankString(words);
        sortAlphabetically(words);
        sortInReverseOrder(words);
        removeDuplicate(words);
        onlyDuplicates(words);
        joinWithStringDelimiters(words);
        countTotalWords(words);
//        countTotalAlphabets(words);
        filterStringsStartingWithLowercase(words);
        filterStringsStartingWithUppercase(words);
        filterStringsStartingWithEmpty(words);
        filterStringsStartingWithNumber(words);
        filterStringsWithLength(words);
    }

    private static void filterStringsWithLength(List<String> words) {
        words.stream().filter(s -> s.length()>5).map(String::valueOf).collect(Collectors.joining(", ")
    }

    private static void filterStringsStartingWithNumber(List<String> words) {
        String numbers = words.stream().filter(s -> !s.isEmpty() && Character.isLetterOrDigit(s.charAt(0))).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with Numbers: "+numbers);
    }

    private static void filterStringsStartingWithEmpty(List<String> words) {
        String space = words.stream().filter(s -> !s.isEmpty() && Character.isSpaceChar(s.charAt(0))).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with space: "+space);
    }

    private static void filterStringsStartingWithUppercase(List<String> words) {
        String upperCase = words.stream().filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0))).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with uppper case: "+upperCase);
    }

    private static void filterStringsStartingWithLowercase(List<String> words) {
        String lowercaseStrings = words.stream().filter(s-> !s.isEmpty() &&  Character.isLowerCase(s.charAt(0))).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with lowercase: "+lowercaseStrings);
    }

    private static void onlyDuplicates(List<String> words) {
        String duplicates = words
                .stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Duplicates Words only: "+ duplicates);
    }

    private static void countTotalWords(List<String> words) {
        long count = words.stream().count();
        System.out.println("Total Words in List of String: "+count);
    }

    private static void joinWithStringDelimiters(List<String> words) {
        String join = words.stream().collect(Collectors.joining("=> "));
        System.out.println("Join With Delimiters: "+join);
    }

    private static void removeDuplicate(List<String> words) {
        String removeDup = words.stream().distinct().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Remove Duplicate Strings: "+removeDup);
    }

    private static void sortInReverseOrder(List<String> words) {
        String reverseSorted = words.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Reverse Order Sorted: "+reverseSorted);
    }

    private static void sortAlphabetically(List<String> words) {
        String collected = words.stream().sorted().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Sorted Alphabetically: "+collected);
    }

    private static void removeEmptyOrBlankString(List<String> words) {
        String removeEmptyString = words.stream().filter(s -> !s.isEmpty()).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Remove Empty String: "+removeEmptyString);
        String removeBlankString = words.stream().filter(s -> !s.isBlank()).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("Remove Blank String: "+removeBlankString);
    }

    private static void convertAllToUpperAndLowerCases(List<String> words) {
        String collected = words.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("ALL IN UPPER CASES: "+collected);
        String lowerCases = words.stream().map(String::toLowerCase).collect(Collectors.joining(", "));
        System.out.println("all in lower cases: "+lowerCases);
    }

    private static void filterByLength(List<String> words) {
        String byLength = words.stream()
                .filter(l -> l.length() > 3)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Filter By Length(3): "+byLength);
    }
}
