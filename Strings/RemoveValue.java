package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveValue {
    public static void main(String[] args) {
        List<String> value=new ArrayList<>(Arrays.asList("apple", "banana", "apple", "cherry"));
        String valueToRemove="apple";
        value.removeIf(lists -> lists.equals(valueToRemove));
        System.out.println(value);
    }
}
