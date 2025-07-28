package Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubStrings {
    
//Approch Sliding Window + set

public static int lengthOfLongestUniqueSubstring(String s){
    Set<Character> charSet= new HashSet<>();
    int start=0, end=0;
    for (int i = 0; i < s.length()-1; i++) {
        while (charSet.contains(s.charAt(i))) {
            charSet.remove(s.charAt(start++));
        }
        charSet.add(s.charAt(i));
        end = Math.max(end,i-start+1);
    }
    return end;
}
    public static void main(String[] args) {
        System.out.println("Starts Application");
        System.out.println("Longest Unique Sub Strings: "+ lengthOfLongestUniqueSubstring("aabcbbbbsbbababababbbbssssss"));
    }
}
