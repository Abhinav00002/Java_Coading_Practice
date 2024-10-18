package DesignPattern;
/**
 * TringunalPyramid
 *         0 
          1 1
         2 2 2
        3 3 3 3
       4 4 4 4 4
      5 5 5 5 5 5
     6 6 6 6 6 6 6
    7 7 7 7 7 7 7 7
   8 8 8 8 8 8 8 8 8
  9 9 9 9 9 9 9 9 9 9
 10 10 10 10 10 10 10 10 10 10 10
 */
public class TringunalPyramid {

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <=i ; j++) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}