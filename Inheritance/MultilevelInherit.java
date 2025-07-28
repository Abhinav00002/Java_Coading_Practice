package Inheritance;



//class Animals{
//    void eat(){
//        System.out.println("Is Eating Barekfast.");
//    }
//}
//class Dog extends Animals{
//    void bark(){
//        System.out.println("Is barking on Thief");
//    }
//}
class Puppy extends Dog{
    void weeping(){
        System.out.println("Is Dog Child Weeping.");
    }
}


public class MultilevelInherit {
    public static void main(String[] args) {
        Puppy d=new Puppy();
//        d.bark();
//        d.eat();
        d.weeping();

    }
}
/*
 * Multilevel inheritance
 *               When there is a chain of inheritance, it is known as multilevel inheritance.
 */
