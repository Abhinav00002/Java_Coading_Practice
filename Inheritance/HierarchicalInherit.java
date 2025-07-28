package Inheritance;


//class Animals{
//    void eating(){
//        System.out.println("Is It Eating BreakFast.");
//    }
//}

//public class Dog extends Animals{
//    void bark(){
//        System.out.println("Is Barking Over Theif.");
//    }
//}
class Cat extends Animals{
    void meow(){
        System.out.println("Mewoing Due to Fear.");
    }
}

public class HierarchicalInherit {
    public static void main(String[] args) {
        Cat c=new Cat();
//        c.eating();
        c.meow();
    
    }
    
}
/*
 * Hierarchical inheritance
 *               When two or more classes inherit a single class, it is known as
 *          hierarchical inheritance. here in the example below, you can see two different classes are 
 *          inherited through the same single class.
 * 
 */