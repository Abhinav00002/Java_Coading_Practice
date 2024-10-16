package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayOperations {
    
    public static void main(String[] args) {
        // Initial array
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original Array: " + Arrays.toString(array));
        
        // Push operation (append element)
        int elementToPush = 8;  
        array = push(array, elementToPush);
        System.out.println("Array after pushing " + elementToPush + ": " + Arrays.toString(array));
        
        // Pop operation (remove last element)
        int poppedElement = pop(array);
        array = Arrays.copyOf(array, array.length - 1);  
        System.out.println("Popped Element: " + poppedElement);
        System.out.println("Array after popping: " + Arrays.toString(array));
        
        // Join operation (concatenate two arrays)
        Integer[] anotherArray = new Integer[]{9, 10};
        Integer[] joinedArray = join(array, anotherArray);
        System.out.println("Array after joining with " + Arrays.toString(anotherArray) + ": " + Arrays.toString(joinedArray));
        
        // Shift operation (remove first element)
        int shiftedElement = shift(joinedArray);
        joinedArray = Arrays.copyOfRange(joinedArray, 1, joinedArray.length); // Resize the array
        System.out.println("Shifted Element: " + shiftedElement);
        System.out.println("Array after shifting: " + Arrays.toString(joinedArray));
        
        // Unshift operation (add element at the start)
        int elementToUnshift = 0; 
        joinedArray = unshift(joinedArray, elementToUnshift);
        System.out.println("Array after unshifting " + elementToUnshift + ": " + Arrays.toString(joinedArray));
    }
    
    // Push operation
    private static Integer[] push(Integer[] array, int element) {
        Integer[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[newArray.length - 1] = element;
        return newArray;
    }
    
    // Pop operation
    private static int pop(Integer[] array) {
        return array[array.length - 1];
    }
    
    // Join operation
    private static Integer[] join(Integer[] array1, Integer[] array2) {
        Integer[] newArray = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        return newArray;
    }
    
    // Shift operation
    private static int shift(Integer[] array) {
        return array[0];
    }
    
    // Unshift operation
    private static Integer[] unshift(Integer[] array, int element) {
        Integer[] newArray = new Integer[array.length + 1];
        newArray[0] = element;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }
}
