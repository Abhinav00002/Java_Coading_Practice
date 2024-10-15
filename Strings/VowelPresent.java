package Strings;

public class VowelPresent {
    public static void main(String[] args){
        String str= "ABHINAV TRIPATHI";
        //Check if Vowel is present
        System.out.println(stringContainVowels(str));
    }
    public static Boolean stringContainVowels(String str){
        return str.toLowerCase().matches(".*[aeiou].*");
    }
}
