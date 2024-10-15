package Numbers;

public class FebbonacciSeries {
    public static void main(String[] args) {
       printFabonacci(10);
    }
    public static  void printFabonacci(int n){
        int a=0;
        int b=1;
        int c=2;
        for (int i=1; i<= n; i++){
            System.out.print(a+", ");
            a=b;
            b=c;
            c=a+b;
        }
    }
}
