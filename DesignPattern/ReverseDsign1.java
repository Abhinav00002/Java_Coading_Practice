package DesignPattern;

public class ReverseDsign1 {
                /*
            1 2 3 4 5 6 7 8 9 10 11 12 13 14 15  
            1 2 3 4 5 6 7 8 9 10 11 12 13 14
            1 2 3 4 5 6 7 8 9 10 11 12 13
            1 2 3 4 5 6 7 8 9 10 11 12
            1 2 3 4 5 6 7 8 9 10 11
            1 2 3 4 5 6 7 8 9 10
            1 2 3 4 5 6 7 8 9
            1 2 3 4 5 6 7 8
            1 2 3 4 5 6 7
            1 2 3 4 5 6
            1 2 3 4 5
            1 2 3 4
            1 2 3
            1 2
            1
                */
    public static void main(String[] args) {
        int a=15;
        for (int i = a; i >=1; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }
}
