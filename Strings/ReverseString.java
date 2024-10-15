package Strings;

public class ReverseString {
    
    public static void main(String[] args) {
        String string="He is a Good Person";
        String reveString= "Good Person";
        System.out.println("Reverse String: "+ reverseString(string, reveString));
    }
    public static String reverseString(String string, String reveString ){

        if(string==null || reveString == null){
            return "String is null";
        }
        StringBuilder reverse=new StringBuilder();
        char[] chars=reveString.toCharArray();
        for(int i=chars.length-1; i>=0; i--){
            reverse.append(chars[i]);
        }
        return string.replace(reveString, reverse.toString());
    }
   
}
