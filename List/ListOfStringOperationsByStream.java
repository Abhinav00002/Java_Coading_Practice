package List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            "banana",          // duplicate
            "123APPLE",          // Digit String
            "ban1ana2",          // duplicate
            "DaD",          // palindrome
            "Anna",
            "Otto",
            "Bob"
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
        filterStringContainingDigits(words);
        filterStringWithSpecialCharacters(words);
        filterStringContainingGivenCharacter(words);
        filterPalindromeString(words);
        filterOnlyLettersAndOnlyDigitsAndOnlyAlphaNumericAndOnlySpaces(words);
        filterStringWithLeadingAndTrailingSpaces(words);
        filterStringEndingWithCharacter(words);
        filterDuplicateString(words);
        trimAllString(words);
        capitalizeFirstLeter(words);
        replaceSpaceWithUnderScore(words);
        removeSpecialCharecter(words);
        reverseEachString(words);
        mapToStringLength(words);
        mapToCharFrequencyMap(words);

    }

    private static void mapToCharFrequencyMap(List<String> words) {
        Map<Character, Long> charFrequency = words.stream().flatMap(s -> s.chars()
                        .mapToObj(c -> (char) c))
                .collect(
                        Collectors.groupingBy(
                                s -> s,
                                Collectors.counting()
                        ));
        List<Map.Entry<Character, Long>> list = charFrequency.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue(
                Comparator.reverseOrder()//For Reverse Order
        )).toList();
        System.out.println(" Character Frequencies: "+charFrequency);
        System.out.println(" Character Frequencies in Reverse Sorted order: "+list);
    }

    private static void mapToStringLength(List<String> words){
        List<Integer> list = words.stream().map(String::length).toList();
        System.out.println("Map to String: "+list);
        Map<String, Integer> collect = words.stream().distinct().collect(Collectors.toMap(s -> s, String::length));
//                  .forEach((word,lengths)-> System.out.println(word +"=>"+lengths));
        System.out.println("Map to String: "+collect);

    }
    private static void reverseEachString(List<String> words){
        List<String> list = words.stream().map(s -> new StringBuilder(s).reverse().toString()).toList();
        System.out.println("Reverse Each String: "+list);

    }
    private static void removeSpecialCharecter(List<String> words){
        List<String> list = words.stream().map(s -> s.replaceAll("[^a-zA-Z0-9]", "")).toList();
        System.out.println("Replace Special Character to \"\": "+list);
    }
    private  static void replaceSpaceWithUnderScore(List<String> words){
        List<String> list = words.stream().map(s -> s.replace(" ", "_")).toList();
        System.out.println("Replace \" \" to _: "+list);

    }
    private static void capitalizeFirstLeter(List<String> words){
        List<String> list = words.stream().map(s -> !s.isEmpty() ?s.substring(0, 1).toUpperCase() + s.substring(1):null).toList();
        System.out.println("Capitalize First Letter: "+ list);
    }
    private static void trimAllString(List<String> word){
        List<String> list = word.stream().map(String::trim).toList();
        System.out.println("Trim All String: "+list);
    }
    private static void filterDuplicateString(List<String> words){
        List<String> list = words.stream().map(String::toLowerCase).distinct().limit(5).skip(0).toList();
        System.out.println("Filter Duplicates String: "+list);
//        List<String> SpecificList = words.stream().map(String::toLowerCase).distinct().limit(5).filter(s->s.equalsIgnoreCase("apple")).toList();
//        System.out.println("Filter Specific Duplicates String: "+SpecificList);

    }
    private static void filterStringEndingWithCharacter(List<String> words){
        List<String> list= words.stream().filter(s -> s.endsWith("y")).toList();
        System.out.println("String Ending With Character(f.e \"y\"): "+list);
    }
    private static void filterStringWithLeadingAndTrailingSpaces(List<String> words){
        List<String> list = words.stream().filter(s -> !s.equals(s.trim())).toList();
        System.out.println("String With Leading and Trailing Spaces: "+list);
    }

    private static void filterOnlyLettersAndOnlyDigitsAndOnlyAlphaNumericAndOnlySpaces(List<String> words) {
        List<String> onlyLetters = words.stream().filter(s -> s.matches("[a-zA-Z]+")).toList();
        System.out.println("Only Contains Letters: "+onlyLetters);
        List<String> onlyNumbers = words.stream().filter(s -> s.matches("\\d+")).collect(Collectors.toList());
        System.out.println("Only Contains Numbers:  "+onlyNumbers);
        List<String> onlyAlphaNumeric = words.stream().filter(s -> s.matches("[a-zA-Z0-9]+")).collect(Collectors.toList());
        System.out.println("Contains AlphaNumeric: "+onlyAlphaNumeric);
        List<String> onlySpaces = words.stream().filter(s -> s.contains(" ")).collect(Collectors.toList());
        System.out.println("Only Contains Spaces: "+onlySpaces);
    }

    private static void filterPalindromeString(List<String> words){
        List<String> list = words.stream().filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())).collect(Collectors.toList());
        System.out.println("Palindrome String: "+list);
    }
    private static void filterStringContainingGivenCharacter(List<String> word){
        Stream<String> a = word.stream().filter(s -> s.contains("a"));
        System.out.println("String Containing Given characters(f.e. \"a\"):"+a.collect(Collectors.toList()));
    }
    private static void filterStringWithSpecialCharacters(List<String> words){
        Stream<String> stringStream = words.stream().filter(s -> s.matches(".*[^a-zA-Z0-9 ].*"));
        System.out.println("Filter String With Special Characters: "+stringStream.collect(Collectors.joining(", ")));
    }
    private static void filterStringContainingDigits(List<String> words){
        String digitString=words.stream().filter(s-> s.matches(".*\\d.*")).collect(Collectors.joining(", "));
        System.out.println("Filter String Containing Digits: "+digitString);
}
    private static void filterStringsWithLength(List<String> words) {
        String string = words.stream().filter(s -> s.length() > 5).collect(Collectors.joining(", "));
        System.out.println("Filter String With Length(Greater Then): "+string);
        String stringLess = words.stream().filter(s -> s.length() < 5).collect(Collectors.joining(", "));
        System.out.println("Filter String With Length(Less Then): "+stringLess);
    }

    private static void filterStringsStartingWithNumber(List<String> words) {
        String numbers = words.stream().filter(s -> !s.isEmpty() && Character.isLetterOrDigit(s.charAt(0))).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with Numbers: "+numbers);
    }

    private static void filterStringsStartingWithEmpty(List<String> words) {
        String space = words.stream().filter(s -> !s.isEmpty() && Character.isSpaceChar(s.charAt(0))).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with space: "+space);
    }

    private static void filterStringsStartingWithUppercase(List<String> words) {
        String upperCase = words.stream().filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0))).collect(Collectors.joining(", "));
        System.out.println("Filter strings starting with uppper case: "+upperCase);
    }

    private static void filterStringsStartingWithLowercase(List<String> words) {
        String lowercaseStrings = words.stream().filter(s-> !s.isEmpty() &&  Character.isLowerCase(s.charAt(0))).collect(Collectors.joining(", "));
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
        String removeDup = words.stream().distinct().collect(Collectors.joining(", "));
        System.out.println("Remove Duplicate Strings: "+removeDup);
    }

    private static void sortInReverseOrder(List<String> words) {
        String reverseSorted = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining(", "));
        System.out.println("Reverse Order Sorted: "+reverseSorted);
    }

    private static void sortAlphabetically(List<String> words) {
        String collected = words.stream().sorted().collect(Collectors.joining(", "));
        System.out.println("Sorted Alphabetically: "+collected);
    }

    private static void removeEmptyOrBlankString(List<String> words) {
        String removeEmptyString = words.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Remove Empty String: "+removeEmptyString);
        String removeBlankString = words.stream().filter(s -> !s.isBlank()).collect(Collectors.joining(", "));
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
                
                .collect(Collectors.joining(", "));
        System.out.println("Filter By Length(3): "+byLength);
    }
}
