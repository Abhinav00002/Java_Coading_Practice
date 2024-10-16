package Strings;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MissingStringFinder {
    
    public static void main(String[] args) {
        String original = "He is a Good Person";
        String reference = "He is a Good Programmer";

        String missing = findMissingCharacters(original, reference);
        System.out.println("Missing Characters: " + missing);
    }

        public static String findMissingCharacters(String original, String reference){
          Set<Character> originalChars=original.chars()
            .mapToObj(c->(char)c)
            .collect(Collectors.toSet());

            String missingCharecter= reference.chars().mapToObj(c -> (char) c)
                                                    .filter(c -> !originalChars.contains(c))
                                                    .map(String :: valueOf)
                                                    .collect(Collectors.joining());
                                                    return  missingCharecter;
        }

    // public static String findMissingCharacters(String original, String reference) {
    //     String missingCharacters = "";

    //     // Check each character in the reference string
    //     for (int i = 0; i < reference.length(); i++) {
    //         char currentChar = reference.charAt(i);
    //         boolean found = false;

    //         // Check if the character is in the original string
    //         for (int j = 0; j < original.length(); j++) {
    //             if (original.charAt(j) == currentChar) {
    //                 found = true;
    //                 break;
    //             }
    //         }

    //         // If not found, add to missing characters
    //         if (!found) {
    //             missingCharacters += currentChar; // Append the missing character
    //         }
    //     }

    //     return missingCharacters;
    // }
}
