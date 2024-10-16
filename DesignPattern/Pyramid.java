package DesignPattern;
 public class Pyramid {
            /*
            1  
            2 2
            3 3 3
            4 4 4 4
            5 5 5 5 5
            */
    public static void main(String[] args) {
        int a=5;
        int b=1;
        for (int i = b; i <= a; i++) {
            for (int j = b; j <=i; j++) {
               System.out.print(i +" ");
            }
            System.out.println(" ");
        }
    }
 }