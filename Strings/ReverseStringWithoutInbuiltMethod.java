package Strings;

public class ReverseStringWithoutInbuiltMethod {
    public static void main(String[] args) {
        String  string=" new String";
       String reverseString= new StringBuilder(string).reverse().toString();
        System.out.println(reverseString);
    }
}
