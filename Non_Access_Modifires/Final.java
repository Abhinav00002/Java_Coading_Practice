package Non_Access_Modifires;

public class Final {
    public static void main(String[] args) {
         // creating object
        Final2 f2=new Final2();
        System.out.println(f2.s1);
        System.out.println(f2.s2);
    }
}
//IF we remove  the final keyword then the programs run fine 
// This class is final
/*final*/
class Final1{
    String s1="Hello!  This is Final Non-Access Modifire.";
}

// We are trying to inherit a final
class Final2 extends Final1{
    String s2="This is Extended Final Class.";
}
