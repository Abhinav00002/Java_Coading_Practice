package DesignPattern;

public class ReversePyramid {

    /*
     * 1 2 3 4 5 6
     * 1 2 3 4 5
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     */

    public static void main(String[] args) {
        int a = 5;
        int b = 1;
        for (int i = b; i <= a; i++) {
            for (int j=b; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}