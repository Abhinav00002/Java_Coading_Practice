package Streams;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<String> words=Arrays.asList("one","two","four","two","three");

      long count=  words.stream().filter(w -> w.length()>3)
        .peek(w->System.out.println("Filterd Word: "+w))
        .count();

        System.out.println("Count: " +count);
    }
}
