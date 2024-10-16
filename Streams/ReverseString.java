package Streams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    // public static void main(String[] args) {
    //     String input="Hello";
    //     String reverse=new StringBuilder(input).reverse().toString();
    //     System.out.println("Reversed: "+reverse); //olleH
    // }
    // public static void main(String[] args) {
    //     String input= "Hello word";
    //     String reverse= IntStream.range(0, input.length())
    //     .mapToObj(i->input.charAt(input.length()-i-1))
    //     .map(String::valueOf)
    //     .collect(Collectors.joining());
    //     System.out.println("Reverse string:"+reverse);//drow olleH
    // }
    public static void main(String[] args) {
        // String input="Hello word";
        // String wordReverse="word";
        
    //     String reverseWord= Arrays.stream(input.split(" "))
    //     .map(word -> word.equals(wordReverse)? new StringBuilder(word).reverse().toString():word)
    //     .collect(Collectors.joining(" "));

    //     System.out.println("Reverse A word from a String: "+ reverseWord);
    // }
        System.out.println("Enter Sentence: ");
        Scanner scn=new Scanner(System.in);
        String input=scn.nextLine();
        System.out.println("Enter String want to reverse: ");
        Scanner scn1= new Scanner(System.in);
        String wordReverse=scn1.nextLine();
        if (input.contains(wordReverse)) {
            String reversedPhrase = new StringBuilder(wordReverse).reverse().toString();
            String result = input.replace(wordReverse, reversedPhrase);
            System.out.println("Reversed phrase from the string: " + result);
        } else {
            System.out.println("The phrase was not found in the sentence.");
        }
    }  
}
