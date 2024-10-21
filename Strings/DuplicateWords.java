package Strings;

import java.util.Arrays;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWords {
    public static void main(String[] args) {
        String text="I am a Java developer and I am proud of it";
       Map<String, Long> duplicateWord= Arrays.stream(text.split("\\s+")).collect(Collectors.groupingBy(String :: toLowerCase, Collectors.counting()))
        .entrySet().stream().filter(entry -> entry.getValue()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Original Text: "+text+"\n Duplocate Word: "+duplicateWord);
    }
}
