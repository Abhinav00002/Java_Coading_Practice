package Numbers;

public class PrimeNumbers{

    public static void main(String[] args) {
        int num=19;
        int num2=49;
        System.out.println("19"+isPrime(num));
        System.out.println("49"+isPrime(num2));
    }
    public static Boolean isPrime(int n){
        if (n==0 ||n==1){
            return false;
        }if(n==2){
            return true;
        }
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}