package Strings;

import java.util.Arrays;

public class SameSetOfCharecters {
    public static boolean haveSameCharacters(String str1, String str2) {
        // Create sorted arrays of distinct characters for each string
        int[] chars1 = str1.chars().sorted().distinct().toArray();
        int[] chars2 = str2.chars().sorted().distinct().toArray();

        // Compare the two arrays
        return Arrays.equals(chars1, chars2);
    }

    public static void main(String[] args) {
        System.out.println(haveSameCharacters("abc", "cba")); 
        System.out.println(haveSameCharacters("abc", "def")); 
        System.out.println(haveSameCharacters("aabbcc", "abc")); 
        }
}
