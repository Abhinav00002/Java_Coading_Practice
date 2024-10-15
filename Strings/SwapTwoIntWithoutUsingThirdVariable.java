package Strings;

public class SwapTwoIntWithoutUsingThirdVariable {
    public static void main(String[] args){
        int a=10;
        int b=20;

        System.out.println("A is: "+a+"\n B is: "+ b);

        a=a+b;
        b=a-b;
        a=b-a;
        System.out.println("A is: "+a+" \n B is: "+ b);

    }
}
