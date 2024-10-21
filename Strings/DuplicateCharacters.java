package Strings;

import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String  name= "AbhinavTripathi";

        Map<Character, Long> duplicateCharacters= name.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
        .entrySet().stream().filter(entry ->entry.getValue()>1)
        .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry :: getValue));

        System.out.println("Original String: "+name+" \nDuplicate Charecters: "+duplicateCharacters);
    }
}